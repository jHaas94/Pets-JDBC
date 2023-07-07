public class Pet {




    private String species;
    private String race;
    private String animalName;
    private int personID;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int householdID) {
        this.personID = householdID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    //region constructor
    public Pet() {
    }
    public Pet(String animalName, String species, String race, int personID) {
        this.species = species;
        this.race = race;
        this.animalName = animalName;
        this.personID = personID;
    }
    //endregion

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", animalName='" + animalName + '\'' +
                ", personID=" + personID +
                '}';
    }
}
