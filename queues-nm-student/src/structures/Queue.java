package structures;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {
  
  
  
  Node<T> head;
  private Node<T> tail;
  private int size;
  public Queue() {
    // TODO 1 
    head = null;
    size = 0;
    tail = null;
  }

  public Queue(Queue<T> other) {
    // TODO 2
    int size = other.size();
    int counter = 0;
    while(!other.isEmpty() && counter<size) {
      this.enqueue(other.peek());
      other.enqueue(other.dequeue());
      counter++;
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO 3
    return (head == null);
  }

  @Override
  public int size() {
    // TODO 4
    return size;
  }

  @Override
  public void enqueue(T element) {
    // TODO 5
    Node<T> node = new Node<T>(element);
    if(tail == null) {
      head = node;
      tail = node;
    }
    else
    {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  @Override
  public T dequeue() throws NoSuchElementException {
    // TODO 6
    if (head == null) 
      throw new NoSuchElementException("empty queue");
    T node = head.data;
    head = head.next;
    size--;
    if(head == null) 
      tail = null;
    return node;
  }

  @Override
  public T peek() throws NoSuchElementException {
    // TODO 7
    if(size == 0)
      throw new NoSuchElementException("empty queue");  
     return head.data;
  }


  @Override
  public UnboundedQueueInterface<T> reversed() {
    // TODO 8
    Queue<T> q = new Queue<T>(this);
    Stack<T> s = new Stack<T>();
    while(!q.isEmpty()) {
      s.push(q.dequeue());
    }
    while(!s.isEmpty()) {
      q.enqueue(s.pop());
    }
    return q;
  }
}

class Node<T> {
  public T data;
  public Node<T> next;
  
  public Node(T data) { 
    this.data = data;
  }
  
  public Node(T data, Node<T> next) {
    this.data = data; 
    this.next = next;
  }
}
class Stack<T> {
  public Node<T> top;
  public int size;
  
  public T pop() {
    if(top == null) 
      return null;
    else
    {
      Node<T> temp = top;
      top = top.next;
      size --;
      return temp.data;
    }
  }
  public T top() {
    if(top == null)
      return null;
    else
      return top.data;
  }
  public boolean isEmpty() {
    return (top == null);
  }
  
  public int size() {
    return size;
  }
  
  public void push(T element) {
    Node<T> temp = top;
    top = new Node<T>(element);
    top.next = temp;
    size++;
  }
}

