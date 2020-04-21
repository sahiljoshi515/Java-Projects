package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
  public int info;
  public LLIntegerNode link;
  
  
  public LLIntegerNode(int info) {
    this.info = info;
    this.link=null;
    
  }
  
  public void setInfo(int i) {
    this.info=i;
    
  }
  public void setLink(LLIntegerNode link) {
    this.link=link;
    
  }
  
  public int getInfo() {
    return this.info;
    
    }
  public LLIntegerNode getLink() {
    return this.link;
  }
  // TODO
}

