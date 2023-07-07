import java.sql.*;
import java.util.ArrayList;

public class PetManagement {

    ArrayList<Pet> pets = new ArrayList<>();

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/petsmanagement",
                "root", "");
    }

    public void createPet(Pet pet) throws SQLException, ClassNotFoundException {

        Connection connection = getConnection();
        pets.add(pet);

        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO pets values(null, ?,?,?,?)");
        prepStatement.setString(1, pet.getAnimalName());
        prepStatement.setString(2, pet.getSpecies());
        prepStatement.setString(3, pet.getRace());
        prepStatement.setInt(4, pet.getPersonID());

        prepStatement.executeUpdate();

        System.out.println("Pet has been added successfully!");

    }

    public void findPet(int pets_id) throws NullPointerException, SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement prepStatement = connection.prepareStatement("SELECT* from pets WHERE pets_id = ?");
        prepStatement.setInt(1, pets_id);
        ResultSet rs = prepStatement.executeQuery();
        while (rs.next()) {
            int petsID = rs.getInt(1);
            String animalName = rs.getString(2);
            String species = rs.getString(3);
            String race = rs.getString(4);
            int personID = rs.getInt(5);
            System.out.println("Pets_id = " + petsID + "\t Name of animal = " + animalName + "\t species = " + species + "\t race = " + race + "\t owner_ID = " + personID);
        }
        rs.close();
        prepStatement.close();
    }

    public void getPets() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement prepStatement = connection.prepareStatement("SELECT* from pets");

        ResultSet rs = prepStatement.executeQuery();

        while (rs.next()) {
            int petsID = rs.getInt(1);
            String animalName = rs.getString(2);
            String species = rs.getString(3);
            String race = rs.getString(4);
            int personID = rs.getInt(5);
            System.out.println("Pets_id = " + petsID + "\t Name of animal = " + animalName + "\t species = " + species + "\t race = " + race + "\t owner_ID = " + personID);
        }
        rs.close();
        prepStatement.close();
    }

    public void updatePet(Pet pet, int household_id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement prepStatement = connection.prepareStatement("UPDATE pets set animal_name = ?, species = ?, race = ? where pets_id = ?");
        prepStatement.setString(1, pet.getAnimalName());
        prepStatement.setString(2, pet.getSpecies());
        prepStatement.setString(3, pet.getRace());

        prepStatement.executeUpdate();
    }

    public void deletePet(int pets_id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement prepStatement = connection.prepareStatement("DELETE FROM pets where pets_id = ?");
        prepStatement.setInt(1, pets_id);

        prepStatement.executeUpdate();
    }
}

