import java.util.*;

public class MyList implements List<Integer>{

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private Object[] elements;

    public MyList() {
        this.size = 0;
        this.capacity = 0;
        elements = new Object[0];
    }
    public MyList(Object[] elements) {
        if (elements == null) {
            this.size = 0;
            this.capacity = 0;
            this.elements = new Object[0];
        } else {
            this.size = elements.length;
            this.capacity = this.size;
            this.elements = Arrays.copyOf(elements, this.size);
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++)
        {
            if(elements[i].equals(o)) return true;
        }
        return false;
    }

    // NONE
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();
                return (Integer) elements[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    //NONE
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
//        if(capacity == 0)
//        {
//            elements = Arrays.copyOf(elements, DEFAULT_CAPACITY);
//            capacity = DEFAULT_CAPACITY;
//            elements[size] = integer;
//            size++;
//            return true;
//        }
//        else
//        {
//            if(size == capacity)
//            {
//                capacity = capacity + (capacity >> 1);
//                elements = Arrays.copyOf(elements, capacity);
//                elements[size] = integer;
//                size++;
//            }
//            elements[size] = integer;
//            size++;
//            return true;
//        }
        ensureCapacity();
        elements[size] = integer;
        size++;
        return true;
    }
    private void ensureCapacity() {
        if(capacity == 0)
        {
            elements = Arrays.copyOf(elements, DEFAULT_CAPACITY);
            capacity = DEFAULT_CAPACITY;
        }else if(capacity == size)
        {
            capacity = capacity + (capacity >> 1);
            elements = Arrays.copyOf(elements, capacity);
        }
    }
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1) return false;
        for(int i = index + 1; i < size; i++)
        {
            elements[i-1] = elements[i];
        }
        size--;
        return true;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c)
        {
            if(!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        ensureCapacity();
        int sz = c.size();
        if((capacity - size) < sz)
        {
            elements = Arrays.copyOf(elements, capacity + sz);
        }
        for(Object o : c)
        {
            elements[size] = o;
            size++;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (c.isEmpty()) {
            return false;
        }
        int sz = c.size();
        ensureCapacity();

        if (capacity - size < sz) {
            capacity = capacity + sz;
            elements = Arrays.copyOf(elements, capacity);
        }
        System.arraycopy(elements, index, elements, index + sz, size - index);
        int i = index;
        for (Integer item : c) {
            elements[i++] = item;
        }
        size += sz;
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(elements[i])) {
                remove(i);
                modified = true;
                i--;
            }
        }
        return modified;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(i);
                modified = true;
                i--;
            }
        }
        return modified;
    }


    @Override
    public void clear() {
        elements = new Object[0];
        size = 0;
        capacity = 0;
    }

    @Override
    public Integer get(int index) {
        if(index < 0 || index >= size) return null;
        return (Integer) elements[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        elements[index] = element;
        return element;
    }

    @Override
    public void add(int index, Integer element) {
        if(index < 0 || index >= size) return;
        ensureCapacity();
        for(int i = index + 1; i < size; i++)
            elements[i] = elements[i-1];
        elements[index] = element;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Integer temp = (Integer) elements[index];
        for(int i = index + 1; i < size; i++)
        {
            elements[i-1] = elements[i];
        }
        size--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++)
        {
            if(elements[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--) if(elements[i].equals(o)) return i;
        return -1;
    }

    @Override
    public ListIterator<Integer> listIterator() {

        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid range: " + fromIndex + " to " + toIndex);
        }
        Object[] subArray = new Object[toIndex - fromIndex + 1];
        System.arraycopy(elements, fromIndex, subArray, 0, toIndex - fromIndex + 1);
        return new MyList(subArray);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
