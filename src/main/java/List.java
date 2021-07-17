public class List {


    private int[] elems;
    private int capacity;
    private int size;

    public List() {
        this.elems = new int[10];
        this.capacity = 10;
        this.size = 0;
    }

    public void addElement(int e) {
        if (this.capacity == this.size) {
            //resize
            int[] copy = new int[2 * this.capacity];
            for (int i = 0; i < this.capacity; i++) {
                copy[i] = this.elems[i];
            }
            this.capacity *= 2;
            this.elems = copy;
        }

        this.elems[this.size] = e;
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public boolean delete(int e) {
        int index = -1;
        for(int i = 0; i < this.size; i++) {
            if(this.elems[i] == e) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        else {
            for (int i = index; i < this.size - 1; i++) {
                this.elems[i] = this.elems[i + 1];
            }
            this.size--;
            return true;
        }
    }

    public ListIterator iterator() {
        return new ListIterator(this);
    }

    public int[] getElems() {
        return this.elems;
    }
}
