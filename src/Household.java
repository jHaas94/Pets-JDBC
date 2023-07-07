public class Household {
    //region Variables




    private String address;


    //endregion

    //region Getters & Setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //endregion

    //region Constructor

    public Household(String address) {
        this.address = address;
    }


    //endregion

    @Override
    public String toString() {
        return "Household{" +
                "address='" + address + '\'' +
                '}';
    }
}
