
public class Person {

    //region Variables


    enum Gender {
        FEMALE,
        MALE,
        DIVERSE,
    }

    private Gender gender;
    private String firstName;
    private String secondName;
    private int householdID;


//endregion

    //region Getters & Setters

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidPersonNameException {

        char[] storesFirstName = firstName.toCharArray();
        boolean containsNumber = false;
        for (char c : storesFirstName) {
            if (Character.isDigit(c)) {
                containsNumber = true;
            }
        }
        if (containsNumber) {
            throw new InvalidPersonNameException("The first name can't contain a number! Try again!");
        } else {
            this.firstName = firstName;
        }
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws InvalidPersonNameException {

        char[] storesSecondName = secondName.toCharArray();
        boolean containsNumber = false;
        for (char c : storesSecondName) {
            if (Character.isDigit(c)) {
                containsNumber = true;
            }
        }
        if (containsNumber) {
            throw new InvalidPersonNameException("The second name can't contain a number! Try again!");
        } else {
            this.secondName = secondName;
        }

    }
    public int getHouseholdID() {
        return householdID;
    }

    public void setHouseholdID(int householdID) {
        this.householdID = householdID;
    }

    //endregion

    //region Constructor
    public Person(Gender gender, String firstName, String secondName, int householdID) {
        this.gender = gender;
        this.firstName = firstName;
        this.secondName = secondName;
        this.householdID = householdID;

    }

    public Person() {

    }


    //endregion


    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", householdID=" + householdID +
                '}';
    }
}
