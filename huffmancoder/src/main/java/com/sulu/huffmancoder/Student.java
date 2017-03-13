/**
 * Created by sulu on 3/9/17.
 */
public class Student {
    public String getName() {
        return name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    private int age;

    public String getMotto() {
        return motto;
    }

    private String motto;

    public Student (String name, int age, String motto) {
        this.name = name;
        this.age = age;
        this.motto = motto;
    }


    public static void main (String [] args) {
        Student s1 = new StudentBuilder().name("Eli").buildStudent();
        Student s2 = new StudentBuilder()
                .name("Spicoli")
                .age(16)
                .motto("Aloha, Mr Hand")
                .buildStudent();
    }

}
