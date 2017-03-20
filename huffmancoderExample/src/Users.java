import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sulu on 3/19/17.
 */
public class Users implements Comparable<Users> {

    public String getUsername() {
        return username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public int compareTo(Users o) {
        int i = -this.username.compareTo(o.getUsername());
        return i;
    }

    public static void main (String[] args) {
        Users user1 = new Users("tpage", "password");

        Users user2 = new Users("zpage", "password");

        List<Users> list = new ArrayList<>();

        list.add(user1);
        list.add(user2);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);
        Collections.sort(list);

    }
}
