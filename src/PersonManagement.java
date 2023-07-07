import java.sql.*;
import java.util.ArrayList;

public class PersonManagement {
    ArrayList<Person> people = new ArrayList<>();

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/petsmanagement",
                "root", "");
    }

    public void createPerson(Person person) throws SQLException, ClassNotFoundException {

        Connection connection = getConnection();
        people.add(person);

        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO persons (gender, firstName, secondName, household_id) values(?,?,?,?)");
        prepStatement.setString(1, String.valueOf(person.getGender()));
        prepStatement.setString(2, person.getFirstName());
        prepStatement.setString(3, person.getSecondName());
        prepStatement.setInt(4, person.getHouseholdID());

        prepStatement.executeUpdate();

        System.out.println("Person has been added successfully!");

    }
    public void findPerson(int person_id) throws NullPointerException, SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT* from persons WHERE person_id = ?");
        prepStatement.setInt(1, person_id);

        ResultSet rs = prepStatement.executeQuery();
        while (rs.next()) {
            int personID = rs.getInt(1);
            String gender = rs.getString(2);
            String firstName = rs.getString(3);
            String secondName = rs.getString(4);
            int householdID = rs.getInt(5);
            System.out.println("Person_id = " + personID + "\t gender = " + gender+ "\t firstname = " + firstName+ "\t secondname = " + secondName + "\t household_ID = " + householdID);
        }
        rs.close();
        prepStatement.close();
    }
    public void getPeople() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement prepStatement = connection.prepareStatement("SELECT* from persons");

        ResultSet rs = prepStatement.executeQuery();

        while (rs.next()) {
            int personID = rs.getInt(1);
            String gender = rs.getString(2);
            String firstName = rs.getString(3);
            String secondName = rs.getString(4);
            int householdID = rs.getInt(5);
            System.out.println("Person_id = " + personID + "\t gender = " + gender+ "\t firstname = " + firstName+ "\t secondname = " + secondName + "\t household_ID = " + householdID);
        }
        rs.close();
        prepStatement.close();
    }

    public void updatePerson(Person person, int person_id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement prepStatement = connection.prepareStatement("UPDATE persons set gender = ?, firstName = ?, secondName = ? where person_id = ?");
        prepStatement.setString(1, String.valueOf(person.getGender()));
        prepStatement.setString(2, person.getFirstName());
        prepStatement.setString(3, person.getSecondName());
        prepStatement.setInt(4, person_id);

        prepStatement.executeUpdate();
    }

    public void deletePerson(int person_id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement prepStatement = connection.prepareStatement("DELETE FROM persons where person_id = ?");
        prepStatement.setInt(1, person_id);

        prepStatement.executeUpdate();
    }


}

