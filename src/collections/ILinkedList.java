package collections;

public interface ILinkedList<E> extends Iterable<E>{

    void add(E element);

    void add(int index, E element);

    void clear();

    E get(int index);

    int indexOf(E elemnt);

    E remove(int index);

    E set(int index, E element);

    int size();

    E[] toArray();

    String toString();

}
