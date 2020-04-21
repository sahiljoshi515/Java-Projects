package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game.
 */
public class LinkedListGame {

  static class LL {
    private LLIntegerNode head;
    private LLIntegerNode tail;

    public LL() {
      head = null;
      tail = null;
    }

    public LLIntegerNode get_head() {
      return head;
    }

    public void insert(LLIntegerNode x) {
      if (head == null) {
        head = x;
        tail = x;

      } else {
        tail.setLink(x);
        ;
        tail = x;
      }
    }

  }

  private LL priorGuesses;
  private LL candidateList;
  int numGuesses;
  boolean gameOver;

  /********************************************************
   * NOTE: for this project you must use linked lists implemented by yourself. You
   * are NOT ALLOWED to use Java arrays of any type, or any class in the java.util
   * package (such as ArrayList).
   *******************************************************/

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
   * provided method, and do NOT add new files (as they will be ignored by the
   * autograder).
   *******************************************************/

  // LinkedListGame constructor method

  public LinkedListGame() {
    candidateList = new LL();
    priorGuesses = new LL();
    gameOver = false;
    numGuesses = 0;
    for (int i = 1000; i <= 9999; i++) {
      candidateList.insert(new LLIntegerNode(i));
    }

  }

  /**
   * Resets data members and game state so we can play again.
   * 
   */
  public void reset() {
    this.candidateList = new LL();
    this.priorGuesses = new LL();
    gameOver = false;
    numGuesses = 0;
    for (int i = 1000; i <= 9999; i++) {
      candidateList.insert(new LLIntegerNode(i));
    }
  }

  /**
   * Returns true if n is a prior guess; false otherwise.
   * 
   */
  public boolean isPriorGuess(int n) {
    if (search(priorGuesses, n))
      return true;
    return false;
  }

  /**
   * Returns the number of guesses so far.
   * 
   */
  public int numGuesses() {
    return numGuesses;
  }

  /**
   * Returns the number of matches between integers a and b. You can assume that
   * both are 4-digits long (i.e. between 1000 and 9999). The return value must be
   * between 0 and 4.
   * 
   * <p>
   * A match is the same digit at the same location. For example: 1234 and 4321
   * have 0 match; 1234 and 1114 have 2 matches (1 and 4); 1000 and 9000 have 3
   * matches (three 0's).
   */
  public static int numMatches(int a, int b) {
    int matches = 0;

    if (a % 10 == b % 10) {
      matches++;
    }
    if ((a / 10) % 10 == (b / 10) % 10) {
      matches++;
    }
    if ((a / 100) % 10 == (b / 100) % 10) {
      matches++;
    }
    if ((a / 1000) == (b / 1000)) {
      matches++;
    }
    return matches;
  }

  /**
   * Returns true if the game is over; false otherwise. The game is over if the
   * number has been correctly guessed or if no candidate is left.
   */
  public boolean isOver() {
    return gameOver;
  }

  /**
   * Returns the guess number and adds it to the list of prior guesses. The
   * insertion should occur at the end of the prior guesses list, so that the
   * order of the nodes follow the order of prior guesses.
   */
  public int getGuess() {
    LLIntegerNode guess = candidateList.get_head();
    priorGuesses.insert(new LLIntegerNode(guess.getInfo()));
    numGuesses++;
    return guess.getInfo();

  }

  private int fetch() {
    return candidateList.get_head().getInfo();

  }

  /**
   * Updates guess based on the number of matches of the previous guess. If
   * nmatches is 4, the previous guess is correct and the game is over. Check
   * project description for implementation details.
   * 
   * <p>
   * Returns true if the update has no error; false if no candidate is left
   * (indicating a state of error);
   */
  private boolean search(LL list, int w) {
    LLIntegerNode temp = list.get_head();
    while (temp != null) {
      if (temp.getInfo() == w) {
        return true;
      }
      temp = temp.getLink();
    }
    return false;
  }

  public boolean updateGuess(int nmatches) {
    if (nmatches == 4) {
      gameOver = true;
    } else {
      LL candidatesNew = new LL();
      if (candidateList.get_head() != null) {
        LLIntegerNode temp = candidateList.get_head();
        while (temp != null) {
          if (numMatches(temp.getInfo(), fetch()) == nmatches) {
            candidatesNew.insert(new LLIntegerNode(temp.getInfo()));
          }
          temp = temp.getLink();

        }
        candidateList = candidatesNew;
      }
    }
    if (candidateList.get_head() == null) {
      gameOver = true;
      return false;
    } else
      return true;
  }

  /**
   * Returns the head of the prior guesses list. Returns null if there hasn't been
   * any prior guess
   */
  public LLIntegerNode priorGuesses() {

    if (priorGuesses.get_head() != null)
      return priorGuesses.get_head();
    else
      return null;
  }

  /**
   * Returns the list of prior guesses as a String. For example, if the prior
   * guesses are 1000, 2111, 3222, in that order, the returned string should be
   * "1000, 2111, 3222", in the same order, with every two numbers separated by a
   * comma and space, except the last number (which should not be followed by
   * either comma or space).
   *
   * <p>
   * Returns an empty string if here hasn't been any prior guess
   */
  public String priorGuessesString() {
    String answer = "";
    LLIntegerNode temp = priorGuesses.get_head();
    if (temp == null)
      return answer;
    while (temp.getLink() != null) {
      answer += temp.getInfo() + ", ";
      temp = temp.getLink();
    }
    answer += temp.getInfo();
    return answer;
  }
}
