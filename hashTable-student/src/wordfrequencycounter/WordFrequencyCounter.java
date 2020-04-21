package wordfrequencycounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import structures.ArrayHashTable;



public class WordFrequencyCounter {
public static ArrayHashTable<String, Integer> hash;

  /**
   * Constructor.
   */
  public WordFrequencyCounter() {
    // TODO 
     hash = new ArrayHashTable<String, Integer>();
  }  

  /**
   * Load file and pass each word in the file to the addword method.
   * @param filename : name of file.
   * @throws IOException : IOException.
   */
  public void loadFile(String filename) throws IOException {
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);
    String line;
    while ((line = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(line);
      while (st.hasMoreTokens()) {
        String temp = st.nextToken();
        addWord(temp);
      }
    }
    br.close();
  }

  /**
   * Return the number of words in the file.
   * @param word : word.
   * @return : the number of word in the file.
   */
  public int countWord(String word) {
    // TODO
    Integer numCount = hash.get(word);
    if(numCount == null) {
      return 0;
    } else
    return numCount;
    
  }
  /**
   * Update word frequency table.
   */
  static void addWord(String word) {
    // TODO
   Integer num = hash.get(word);
   if(num == null) {
     hash.put(word, 1);
   }
   else { 
     num = hash.get(word);
     hash.remove(word);
     hash.put(word, num+1);
   }
     
  }
}
