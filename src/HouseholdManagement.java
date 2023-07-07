import java.sql.*;
import java.util.ArrayList;


public class HouseholdManagement {

        ArrayList<Household> households = new ArrayList<>();

        public Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/petsmanagement",
                    "root", "");
        }

        public void createHousehold(Household household) throws SQLException, ClassNotFoundException {

            Connection connection = getConnection();
            households.add(household);

            PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO households (address) values(?)");
            prepStatement.setString(1, household.getAddress());

            prepStatement.executeUpdate();

            System.out.println("Household has been added successfully!");

        }
        public void findHousehold(int household_id) throws NullPointerException, SQLException, ClassNotFoundException {
            Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement("SELECT* from Households WHERE household_id = ?");
            prepStatement.setInt(1, household_id);

            ResultSet rs = prepStatement.executeQuery();
            while (rs.next()) {
                int householdID = rs.getInt(1);
                String address = rs.getString(2);
                System.out.println("Household_id = " + householdID + "\t address = " + address);
            }
            rs.close();
            prepStatement.close();
        }
        public void getHouseholds() throws SQLException, ClassNotFoundException {
            Connection connection = getConnection();

            PreparedStatement prepStatement = connection.prepareStatement("SELECT* from households");

            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()) {
                int householdID = rs.getInt(1);
                String address = rs.getString(2);
                System.out.println("Household_id = " + householdID + "\t address = " + address);
            }
            rs.close();
            prepStatement.close();
        }

        public void updateHousehold(Household household, int household_id) throws SQLException, ClassNotFoundException {
            Connection connection = getConnection();

            PreparedStatement prepStatement = connection.prepareStatement("UPDATE households set address = ? where household_id = ?");
            prepStatement.setString(1, household.getAddress());
            prepStatement.setInt(2, household_id);

            prepStatement.executeUpdate();
        }

        public void deleteHousehold(int household_id) throws SQLException, ClassNotFoundException {
            Connection connection = getConnection();

            PreparedStatement prepStatement = connection.prepareStatement("DELETE FROM households where household_id = ?");
            prepStatement.setInt(1, household_id);

            prepStatement.executeUpdate();
        }
    }


