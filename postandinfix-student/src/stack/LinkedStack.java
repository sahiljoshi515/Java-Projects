package stack;

/**
 * A {@link LinkedStack} is a generic stack that is implemented using a Linked
 * List structure to allow for unbounded size.
 */
public class LinkedStack<T> {

  // TODO: define class variables here
  public LLNode<T> top;
  public int size = 0;

  /**
   * Remove and return the top element on this stack. If stack is empty, return
   * null (instead of throw exception)
   */
  public T pop() {
    // TODO
    if (top == null)
      return null;
    else {
      LLNode<T> temp = top;
      top = top.link;
      size--;
      return temp.info;
    }

  }

  /**
   * Return the top element of this stack (do not remove the top element). If
   * stack is empty, return null (instead of throw exception)
   */
  public T top() {
    // TODO
    if (top == null)
      return null;
    else
      return top.info;
  }

  /**
   * Return true if the stack is empty and false otherwise.
   */
  public boolean isEmpty() {
    // TODO
    return (top == null);
  }

  /**
   * Return the number of elements in this stack.
   */
  public int size() {
    // TODO
    return size;
  }

  /**
   * Pushes a new element to the top of this stack.
   */
  public void push(T elem) {
    // TODO
    LLNode<T> temp = top;
    top = new LLNode<T>(elem);
    top.link = temp;
    size++;
  }

}
