package space.sakibnm.okhttpdemo;

import java.util.ArrayList;

public class Persons {
    private ArrayList<Person> persons;

    public Persons() {
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "persons=" + persons +
                '}';
    }
}
