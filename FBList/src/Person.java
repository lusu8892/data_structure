/**
 * Created by sulu on 2/14/17.
 */
public class Person {
    private String personName;
    private Long phoneNumber;

    private Person next;

    /**
     * Default Constructor
     */
    public Person () {
        this(null, null, null);
    }

    /**
     * Second Constructor
     * @param personName
     * @param phoneNumber
     */
    public Person(String personName, Long phoneNumber) {
        this( personName, phoneNumber, null);
//        this.next = null;
    }

    /**
     * Third Constructor
     * @param personName
     * @param phoneNumber
     * @param next
     */
    public Person(String personName, Long phoneNumber, Person next) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.next = next;
    }

    /**
     * Fourth Constructor
     * @param person
     * @param next
     */
    public Person (Person person, Person next) {
        this(person.getPersonName(), person.getPhoneNumber(), next);
    }

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
