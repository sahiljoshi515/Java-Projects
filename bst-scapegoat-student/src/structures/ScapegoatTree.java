package structures;

import java.util.Iterator;

public class ScapegoatTree<T extends Comparable<T>> extends BinarySearchTree<T> {
  private int upperBound;


  @Override
  public void add(T t) {
    // TODO
    upperBound++;
    BSTNode<T> newNode = new BSTNode<T>(t, null, null);
    root = addToSubtree(root, newNode);
    if (height() > Math.log(upperBound) / Math.log((double)3/2)) {
      BSTNode<T> child = newNode;
      BSTNode<T> w = newNode.parent;
      while ((double)subtreeSize(child)/ subtreeSize(w) <= (double)2/3) {
          w = w.parent;
          child = child.parent;
      }
    
      ScapegoatTree<T> subtree = new ScapegoatTree<T>();
      subtree.root = w;
      BSTNode<T> originalParent = w.parent;
      subtree.balance();
      if (originalParent.getLeft() == w) originalParent.setLeft(subtree.root);
      else originalParent.setRight(subtree.root);
  }
  }
 
  @Override
  public boolean remove(T element) {
    // TODO
    if (element == null) {
      throw new NullPointerException();
  }
  boolean result = contains(element);
  if (result) {
      root = removeFromSubtree(root, element);
  }
  if (upperBound > 2*size()) {
      balance();
      upperBound = size();
  }
  return result; 
}
    
  }

