package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 */
public class LevelOrderIterator extends FileIterator<File> {

  /**
   * Instantiate a new LevelOrderIterator, rooted at the rootNode.
   * @param rootNode : node of the root.
   * @throws FileNotFoundException if the rootNode does not exist.
   */
  private File rn;
  private Queue<File> q;
  public LevelOrderIterator(File rootNode) throws FileNotFoundException {
    // TODO 1
    if(!rootNode.exists())
      throw new FileNotFoundException();
    this.rn = rootNode;
    q = new Queue<File>();
    q.enqueue(this.rn);
  } 

  @Override
  public boolean hasNext() {
    // TODO 2
    if(!q.isEmpty())
      return true;
    else
    return false;
  }

  @Override
  public File next() throws NoSuchElementException {
    // TODO 3
    if(!hasNext()) 
      throw new NoSuchElementException();
    File now = null;
    now = q.dequeue();
    if(now.isDirectory()) 
    {
      File[] arr = now.listFiles();
      Arrays.sort(arr);
      for(int i=0;i<arr.length;i++) {
        if(arr[i].exists()) 
          q.enqueue(arr[i]);
      }
      
      
    }
    return now;
  }

  @Override
  public void remove() {
    // Leave this one alone.
    throw new UnsupportedOperationException();
  }

}
