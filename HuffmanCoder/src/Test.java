/**
 * Created by sulu on 3/7/17.
 */
/**
 * 父类
 */
public class Test {

    static String sVar = getString("父类静态变量初始化");
    public String var = getString("父类非静态变量初始化");

    static {
        System.out.println("父类的静态初始化块");
    }

    {
        System.out.println("父类的非静态初始化块");
    }

    public Test() {
        System.out.println("父类构造函数 start");
        draw("父类调用draw方法");//会调用子类覆盖后的方法，这里是null
        System.out.println("父类构造函数 end");
    }

    static String getString(String base) {
        System.out.println(base);
        return base;
    }

    public void draw(String string) {
        System.out.println(string);
    }
}
