// Create class for working with Persons
public class Person implements Comparable {
    private String firstName;
    private String lastName;


    @Override
    public int compareTo(Object o) {
        if(o instanceof Person)
        {
            Person p = (Person)o;
            int result = this.lastName.compareTo(p.lastName);
            if(result==0)
                result = this.firstName.compareTo(p.firstName);
            return result;
        }
        return 0;
    }

    //Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Get first name
    public String getFirstName() {
        return firstName;
    }

    //Set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Get last name
    public String getLastName() {
        return lastName;
    }

    //Set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Overide ToString
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
