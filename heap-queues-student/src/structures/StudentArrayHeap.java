package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
  
  public StudentArrayHeap(Comparator<P> comparator) {
    super(comparator);
  }
  
  
  protected int getLeftChildOf(int index) {
    
    if (index < 0) throw new IndexOutOfBoundsException();
    return 2*index + 1;
    
  }
  
  protected int getRightChildOf(int index) {
    if (index < 0) throw new IndexOutOfBoundsException();
    return 2*index + 2;
    
  }
  
  protected int getParentOf(int index) {
    if (index < 1) throw new IndexOutOfBoundsException();
    return (index-1)/2;
    
  }
  
  
  protected void bubbleUp(int index) {
    Entry<P, V> elem = heap.get(index);
    int parent = (index-1)/2;
    while((index > 0) && getComparator().compare(elem.getPriority(), heap.get(parent).getPriority()) > 0) {
      heap.set(index, heap.get(parent));
      index = parent;
      parent = (parent - 1)/2;
    }
    
    heap.set(index, elem);
    
  }
  
  protected void bubbleDown(int index) {
    Entry<P, V> elem = heap.get(index);
    int largerChild;
    while(index < this.heap.size()/2) {
      int left = getLeftChildOf(index);
      int right = getRightChildOf(index);
      if (right < heap.size() && getComparator().compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0) {
        largerChild = right;
        } 
      else {
        largerChild = left; 
      }
      if (getComparator().compare(elem.getPriority(), heap.get(largerChild).getPriority()) >= 0) {
        break;
      }
      else {
        heap.set(index, heap.get(largerChild));
        index = largerChild;
      }
    }
    
    heap.set(index, elem);
  
  
  }
}

