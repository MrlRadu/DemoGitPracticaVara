public class MapIterator {
    private Map map;
    private int index;

    public MapIterator(Map m) {
        this.map = m;
        this.index = 0;
    }

    public void first() {
        this.index = 0;
    }

    public void next() {
        if (this.index < this.map.getNrElems()) {
            this.index++;
        }
        else throw new IndexOutOfBoundsException();
    }

    public Pair getCurrent() {
        if (this.index < this.map.getNrElems()) {
            return this.map.getElems()[this.index];
        } else throw new IndexOutOfBoundsException();
    }

    public boolean valid() {
        return this.index < this.map.getNrElems() && !this.map.isEmpty();
    }
}
