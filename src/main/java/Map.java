
public class Map {
    private int cap;
    private int nrElems;
    private Pair<Integer, Integer>[] elems;

    public Map() {
        this.cap = 10;
        this.nrElems = 0;
        this.elems = new Pair[10];
    }

    public int add(int k, int v) {
        if (this.nrElems == this.cap) {
            Pair<Integer, Integer>[] resize = new Pair[this.cap * 2];
            for (int i = 0; i < this.nrElems; i++) {
                resize[i] = this.elems[i];
            }
            this.cap *= 2;
            this.elems = resize;
        }
        int index = 0;
        while (index < this.nrElems) {
            if (this.elems[index].getKey() == k) {
                int oldValue = this.elems[index].getValue();
                this.elems[index].setValue(v);
                return oldValue;
            }
            index++;
        }
        if (index == this.nrElems) {
            Pair<Integer, Integer> newpair = new Pair<Integer, Integer>(k, v);
            this.elems[index] = newpair;
            this.nrElems++;
        }
        return -1;
    }

    public int search(int k) {
        for (int index = 0; index < this.nrElems; index++) {
            if (this.elems[index].getKey() == k) {
                return this.elems[index].getValue();
            }
        }
        return -1;
    }

    public int remove(int k) {
        int v = -1;
        boolean found = false;
        int index;
        for (index = 0; index < this.nrElems; index++) {
            if (this.elems[index].getKey() == k) {
                v = this.elems[index].getValue();
                found = true;
                break;
            }
        }

        if (found) {
            while (++index < this.nrElems) {
                this.elems[index - 1] = this.elems[index];
            }
            this.nrElems--;
        }
        return v;
    }

    public int size() {
        return this.nrElems;
    }

    boolean isEmpty() {
        return this.nrElems == 0;
    }

    MapIterator iterator() {
        return new MapIterator(this);
    }

    public int getNrElems() {
        return this.nrElems;
    }

    public Pair[] getElems() {
        return this.elems;
    }
}
