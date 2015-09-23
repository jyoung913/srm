import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private int next;
    private boolean hasNxt;
    Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (it.hasNext()) {
            hasNxt = true;
            next = it.next();
        } else {
            next = 0;
            hasNxt = false;
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = next;
        if (it.hasNext()) {
            hasNxt = true;
            next = it.next();
        } else {
            next = 0;
            hasNxt = false;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return hasNxt;
    }
}