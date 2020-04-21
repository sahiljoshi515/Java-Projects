package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LLNodeIterator<T> implements Iterator<T> {

  private LLNode<T> node;

  public LLNodeIterator(LLNode<T> node) {
    this.node = node;
  }

  public boolean hasNext() {
    return node != null;
  }

  public T next() {
    if (!hasNext())
      throw new NoSuchElementException();
    T element = node.getInfo();
    node = node.getLink();
    return element;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
  
  

}
