package collections;


import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public MyLinkedList() {
        //боковые нулевые ноды, они существуют всегда
        lstNode = new Node<>(fstNode, null, null);
        fstNode = new Node<>(null, null, lstNode);
    }

    private void addFirst(E e) {
        Node<E> firstEl = fstNode;
        fstNode = new Node<>(null, null, firstEl);
        firstEl.setItem(e);
        firstEl.setPrev(fstNode);
        size++;

    }

    private void addLast(E e) {
        Node<E> lastEl = lstNode;
        lstNode = new Node<>(lastEl, null, null);
        lastEl.setItem(e);
        lastEl.setNext(lstNode);
        size++;
    }

    @Override
    public void add(E element) {
        addLast(element);
    }

    @Override
    public void add(int index, E element) {
        if(index >= 0 && index <= size) {
            if(index == size) {
                addLast(element);
            }
            else {
                Node<E> succ = node(index);
                final Node<E> pred = succ.prev;
                final Node<E> newNode = new Node<>(pred, element, succ);
                succ.prev = newNode;
                if (pred == null)
                    fstNode = new Node<>(null, null, newNode);
                else
                    pred.next = newNode;
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        size++;
    }

    @Override
    public void clear() {
        for (Node<E> x = fstNode.next; x != lstNode; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        fstNode = lstNode = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> target = fstNode.getNext();
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target.getItem();
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = fstNode.next; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = fstNode.next; x != null; x = x.next) {
                if (element.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if(index >= 0 && index < size) {

            Node<E> x = node(index);
            final E element = x.item;
            final Node<E> next = x.next;
            final Node<E> prev = x.prev;

            if (prev == null) {
                fstNode = new Node<>(null, null, next);
            } else {
                prev.next = next;
                x.prev = null;
            }

            if (next == null) {
                lstNode = new Node<>(prev, null, null);

            } else {
                next.prev = prev;
                x.next = null;
            }

            x.item = null;
            size--;
            return element;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        if(index >= 0 && index < size) {
            Node<E> x = node(index);
            E oldVal = x.item;
            x.item = element;
            return oldVal;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public int size() {
        return size;
    }

    public <T> T[] toArray(T[] array) {
        int i = 0;
        if(array.length < size) {
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        }

        Object[] tempArray = array;
        for (Node<E> x = fstNode.next; x != lstNode; x = x.next) {
            tempArray[i++] = x.item;
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public E[] toArray() {
        E[] resultArray;
        resultArray = (E[]) java.lang.reflect.Array.newInstance(fstNode.next.item.getClass(), size);
        int i = 0;
        for (Node<E> x = fstNode.next; x != lstNode; x = x.next) {
            resultArray[i++] = x.item;
        }
        return resultArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    @Override
    public String toString() {
        String str = "";
        str = "MyLinkedList consists of: ";
        for (Node<E> x = fstNode.next; x != lstNode; x = x.next) {
            str += x.item + ", ";
        }
        str = str.substring(0, str.length() - 2);

        return str;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public void setItem(E item) {
            this.item = item;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = fstNode.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = lstNode.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

}
