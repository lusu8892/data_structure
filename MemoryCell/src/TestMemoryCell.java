/**
 * Created by sulu on 2/1/17.
 */
public class TestMemoryCell {
    public static void main(String [] args) {

        MemoryCell s = new MemoryCell();

        s.write( "37" );
        String val = (String) s.read( );
        System.out.println( "Contents are: " + val );

        s.write(89);

        int int_val = (int) s.read();
        System.out.println(int_val);
    }
}
