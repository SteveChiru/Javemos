import org.junit.Test;

/**
 * @Description:
 */
public class JavaBasicTest {

    @Test
    public void testTryCatch(){
        int a=10;
        System.out.println(a);

        try {
            int b = 10/0;
            System.out.println(b);
        }catch (Exception e){
            e.printStackTrace();
        }

        int c = 30;
        System.out.println(c);
    }
}
