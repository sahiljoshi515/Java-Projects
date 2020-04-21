package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

  protected int numElements;
  protected LLNode<T> list;

  public Iterator<T> iterator() {
    return new LLNodeIterator<T>(list);
  }

  public int size() {
    return numElements;
  }

  public ListInterface<T> insertAt(int index, T element) {
    if (index < 0 || index > numElements)
      throw new IndexOutOfBoundsException();

    if (element == null)
      throw new NullPointerException();
    LLNode<T> newNode = new LLNode<T>(element);
    if (index == 0) {
      newNode.setLink(list);
      list = newNode;
    } else
      insert(list, index, newNode);
    numElements++;
    return this;

  }

  private void insert(LLNode<T> curr, int index, LLNode<T> newNode) {
    if (index == 1) {
      newNode.setLink(curr.getLink());
      curr.setLink(newNode);
    } else
      insert(curr.getLink(), index - 1, newNode);

  }

  public ListInterface<T> insertFirst(T element) {
    return insertAt(0, element);

  }

  public ListInterface<T> insertLast(T element) {
    return insertAt(numElements, element);
  }

  public T removeAt(int index) {
    if (index < 0 || index >= numElements)
      throw new IndexOutOfBoundsException();
    T element;
    if (index == 0) {
      element = list.getInfo();
      list = list.getLink();
    } else
      element = remove(list, index);
    numElements--;
    return element;

  }

  private T remove(LLNode<T> trav, int index) {

    if (index == 1) {
      T element = trav.getLink().getInfo();
      trav.setLink(trav.getLink().getLink());
      return element;
    } else
      return remove(trav.getLink(), index - 1);
  }

  public T removeFirst() {
    if (isEmpty())
      throw new IllegalStateException();
    return removeAt(0);
  }

  public T removeLast() {
    if (isEmpty())
      throw new IllegalStateException();
    return removeAt(numElements - 1);
  }

  public T get(int index) {
    if (index < 0 || index >= numElements)
      throw new IndexOutOfBoundsException();
    return getHelp(list, index);
  }

  private T getHelp(LLNode<T> trav, int index) {
    if (index == 0)
      return trav.getInfo();
    else
      return getHelp(trav.getLink(), index - 1);
  }

  public T getFirst() {
    if (isEmpty())
      throw new IllegalStateException();
    return get(0);
  }

  public T getLast() {
    if (isEmpty())
      throw new IllegalStateException();
    return get(numElements - 1);
  }

  public boolean remove(T element) {
    int index = indexOf(element);
    if (index == -1)
      return false;
    removeAt(index);
    return true;
  }

  public int indexOf(T element) {
    if (element == null)
      throw new NullPointerException();
    else
      return findIndex(element, list, 0);
  }

  private int findIndex(T element, LLNode<T> trav, int index) {
    if (trav == null)
      return -1;
    if (trav.getInfo().equals(element))
      return index;
    else
      return findIndex(element, trav.getLink(), index + 1);
  }

  public boolean isEmpty() {
    return list == null;
  }
}
