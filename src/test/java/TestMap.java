import org.junit.Assert;
import org.junit.Test;

public class TestMap {
    @Test
    public void shortTest() {
        Map m = new Map();
        Assert.assertTrue(m.isEmpty());
        Assert.assertEquals(0, m.size());
        Assert.assertEquals(-1, m.add(5, 5));
        Assert.assertEquals(-1, m.add(1, 111));
        Assert.assertEquals(-1, m.add(10, 110));
        Assert.assertEquals(-1, m.add(7, 7));
        Assert.assertEquals(111, m.add(1, 1));
        Assert.assertEquals(110, m.add(10, 10));
        Assert.assertEquals(-1, m.add(-3, -3));
        Assert.assertEquals(5, m.size());
        Assert.assertEquals(10, m.search(10));
        Assert.assertEquals(-1, m.search(16));
        Assert.assertEquals(1, m.remove(1));
        Assert.assertEquals(-1, m.remove(6));
        Assert.assertEquals(4, m.size());


        Pair<Integer, Integer> e;
        MapIterator id = m.iterator();
        id.first();
        int s1 = 0, s2 = 0;
        while (id.valid()) {
            e = id.getCurrent();
            s1 += e.getKey();
            s2 += e.getValue();
            id.next();
        }
        Assert.assertEquals(19, s1);
        Assert.assertEquals(19, s2);
    }
}
