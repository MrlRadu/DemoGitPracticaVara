public class ListIterator {
    private List l;
    private int index;

    public ListIterator(List list) {
        this.l = list;
        this.index = 0;
    }

    public boolean valid() {
        return 0 <= this.index && this.index < this.l.getSize();
    }

    public void first() {
        this.index = 0;
    }

    public void next() {
        this.index++;
    }

    public int getElement() {
        return this.l.getElems()[this.index];
    }
}
