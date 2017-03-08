/**
 * Created by sulu on 3/7/17.
 */
/**
 * 父类
 */
public class Test {

    static {
        System.out.println("父类的static静态初始化块block");
    }

    {
        System.out.println("父类的非静态初始化块block");
    }
    static String sVar = getString("父类static静态变量初始化");
//    static String ssVar = getString1("")
private String privateVar = getString("父类private非静态变量初始化");
    public String var = getString("父类public非静态变量初始化");
    String defaultVar = getString("父类default非静态变量初始化");





    public Test() {
        System.out.println("父类构造函数 start");
        draw("父类调用draw方法");//会调用子类覆盖后的方法，这里是null
        System.out.println("父类构造函数 end");
    }

//    private String getString1(String base) {
//        System.out.println(base);
//        return base;
//    }

    static String getString(String base) {
        System.out.println(base);
        return base;
    }

    public void draw(String string) {
        System.out.println(string);
    }


//    public static void main (String [] args) {
//        Test test = new Test();
//        System.out.println("Main Function");
//    }
}
