import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {
    public static void main(String[] args) {
        PersonManagement persons = new PersonManagement();
        PetManagement pets = new PetManagement();
        HouseholdManagement households = new HouseholdManagement();

        Person testPerson1 = new Person(Person.Gender.FEMALE, "Maria", "Hofer", 1);
        try {
            persons.createPerson(testPerson1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Pet testPet1 = new Pet("Schnurli", "Cat", "Angora", 1);
        try {
            pets.createPet(testPet1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pets.getPets();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




