/**
 * Created by sulu on 3/7/17.
 */
/**
 * 子类
 */
public class SubTest extends Test {

    public String var = getString("子类初始化非静态变量");
    private String subVar = getString("子类初始化私有变量");
    static String superVar = getString("子类初始化静态变量");

    static {
        System.out.println("子类的静态初始化块");
    }

    {
        System.out.println("子类的非静态初始化块");
    }

    SubTest() {
        System.out.println("子类构造函数start");
        draw("子类调用draw方法");
        System.out.println("子类构造函数end");
    }

    public void draw(String string) {
        System.out.println(string + subVar);
    }

    public static void main(String[] args) {
        new SubTest();
    }
}
