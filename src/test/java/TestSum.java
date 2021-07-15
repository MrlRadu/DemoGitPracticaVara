import org.junit.Test;
import sum.Sum;
import static org.junit.Assert.*;

public class TestSum {

    @Test
    public void testAdd() {
        Sum sum = new Sum();
        int result = sum.add(5,5);
        assertEquals(result,10);
        assertEquals(sum.add(1,2),3);
    }
}

