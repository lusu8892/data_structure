/**
 * Created by sulu on 2/14/17.
 */
public class Person {
    private String personName;
    private long phoneNumber;

    private Person next;


    public void setData(String personName, long phoneNumber) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setNext(Person person) {
        this.next = person;
    }

    public Person getNext() {
        return next;
    }
}
