import org.junit.Assert;
import org.junit.Test;

public class TestList {
    @Test
    public void shortTest() {
        List l = new List();

        Assert.assertEquals(0, l.getSize());

        l.addElement(5);
        l.addElement(9);
        l.addElement(4);
        l.addElement(3);
        Assert.assertEquals(4, l.getSize());

        l.delete(4);
        Assert.assertEquals(3, l.getSize());


        ListIterator li = l.iterator();
        int sum = 0;
        while (li.valid()) {
            sum += li.getElement();
            li.next();
        }
        Assert.assertEquals(17, sum);
    }
}
