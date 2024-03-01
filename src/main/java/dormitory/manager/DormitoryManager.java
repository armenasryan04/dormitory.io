package dormitory.manager;



import dormitory.db.DBConnectionProvider;
import dormitory.models.Dormitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DormitoryManager {
    Connection connection = DBConnectionProvider.getInstance().getConnection();
    public List<Dormitory> getAll(){
        List<Dormitory> dormitories = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
           ResultSet resultSet = statement.executeQuery("select * from dormitory");
           while (resultSet.next()){
               dormitories.add(getFromResultSet(resultSet));
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dormitories;
    }
    public List<Dormitory> getOnlyFreeRooms() {
        List<Dormitory> freeDormitories = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from dormitory ");
            while (resultSet.next()) {
                Dormitory dormitory = getFromResultSet(resultSet);
                if (isFree(dormitory.getId())) {
                    freeDormitories.add(dormitory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return freeDormitories;
    }

    public boolean isFree(int id) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select 1 from  student where status = 'ACTIVE' AND room_id = " + id);
            if (resultSet.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Dormitory getById(int id) {
        Dormitory dormitory = new Dormitory();
        String sql = "SELECT * FROM dormitory WHERE room_id = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dormitory = getFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dormitory;
    }

    private Dormitory getFromResultSet(ResultSet resultSet) throws SQLException {
        ReceptionistManager receptionistManager = new ReceptionistManager();
        Dormitory dormitory = Dormitory.builder()
                .id(resultSet.getInt("room_id"))
                .floor(resultSet.getInt("floor"))
                .responsible(receptionistManager.getById(resultSet.getInt("responsible_id"))).build();
        return dormitory;
    }
}
