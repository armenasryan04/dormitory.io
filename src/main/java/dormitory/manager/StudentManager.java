package dormitory.manager;


import dormitory.db.DBConnectionProvider;
import dormitory.models.Dormitory;
import dormitory.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    DormitoryManager dormitoryManager = new DormitoryManager();

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from student order by name asc ");
            while (resultSet.next()) {
                students.add(getFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public List<Student> getByNameOrSurname(String search){
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE UPPER(name) LIKE CONCAT('%', UPPER(?), '%') OR UPPER(surname) LIKE CONCAT('%', UPPER(?), '%')\n";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + search + "%");
            statement.setString(2, "%" + search + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(getFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public Student getById(int id) {
        Student student = new Student();
        String sql = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student addToDB(Student student) {
        String sql = "insert  into student(name,surname,email,phone_num,date,room_id) values (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhoneNum());
            preparedStatement.setDate(5, (Date) student.getDate());
            preparedStatement.setInt(6, student.getDormitory().getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                student.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
        }
        return student;
    }

    public void changeById(int id, Student student) {
        String name = student.getName();
        String surname = student.getSurname();
        String email = student.getEmail();
        String phoneNum = student.getPhoneNum();
        Date date = (Date) student.getDate();
        int roomId = student.getDormitory().getId();
        String sql = "update student set name = ?,surname = ?,email = ?,phone_num = ?,date = ?,room_id = ? where id = " + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phoneNum);
            preparedStatement.setDate(5, date);
            preparedStatement.setInt(6, roomId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("delete from  student where id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Student getFromResultSet(ResultSet resultSet) throws SQLException {
        Dormitory dormitory = dormitoryManager.getById(resultSet.getInt("room_id"));
        Student student = Student.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .phoneNum(resultSet.getString("phone_num"))
                .date(resultSet.getDate("date"))
                .dormitory(dormitory)
                .build();
        return student;
    }
}
