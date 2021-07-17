import org.junit.Assert;
import org.junit.Test;

public class testAll {
    @Test
    public void testAdd() {
        Add a = new Add();
        Assert.assertEquals(a.addNumbers(2, 3), 5);
    }
}
