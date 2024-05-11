package lib;

import java.util.ArrayList;

public class ArrayStackList<T> {
    private int idx;
    private ArrayList<T> data;

    public ArrayStackList() {
        data = new ArrayList<T>();
        idx = -1;
    }

    public void push(T element) {
        this.idx++;
        this.data.add(element);
    }

    public T undo() {
        if (this.idx > 0) {
            this.idx--;
            return this.data.get(this.idx);
        }
        return null;
    }

    public T redo() {
        if (this.idx < this.data.size() - 1) {
            this.idx++;
            return this.data.get(this.idx);
        }
        return null;
    }

    public void reset() {
        this.data = new ArrayList<T>();
        this.idx = -1;
    }

    public T peek() {
        if (this.idx > 0) {
            return this.data.get(this.idx);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.idx > 0;
    }
}
