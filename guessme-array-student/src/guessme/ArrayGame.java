package guessme;

/**
 * An Array-based implementation of the Guess-A-Number game.
 */
public class ArrayGame {

  // stores the next number to guess
  private int ctrguess;
  private int[] guesses = new int[9000];
  private int index = 0;
  private boolean[] candidates = new boolean[9000];
  private boolean gameOver = false;

  // TODO: declare additional data members, such as arrays that store
  // prior guesses, eliminated candidates etc.

  // NOTE: only primitive type arrays are allowed, such as int[], boolean[] etc.
  // You MAY NOT use any Collection type (such as ArrayList) provided by Java.

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
   * provided method, otherwise your code will fail the JUnit tests. Also DO NOT
   * create any new Java files, as they will be ignored by the autograder!
   *******************************************************/

  // ArrayGame constructor method
  public ArrayGame() {
    for (int i = 0; i < candidates.length; i++) {
      candidates[i] = true;
    }
    // TODO
  }

  /**
   * Resets data members and game state so we can play again.
   */
  public void reset() {
    for (int i = 0; i < candidates.length; i++) {
      candidates[i] = true;

    }
    gameOver = false;
    guesses = new int[9000];
    index = 0;
    ctrguess = 0;
    // TODO
  }

  /**
   * Returns true if n is a prior guess; false otherwise.
   */
  public boolean isPriorGuess(int n) {
    if (search(guesses, n)) {
      return true;
    }
    return false;
    // TODO

  }

  /**
   * Returns the number of guesses so far.
   */
  public int numGuesses() {

    // TODO
    return ctrguess;
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
  public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
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

    // TODO
    return matches;
  }

  /**
   * Returns true if the game is over; false otherwise. The game is over if the
   * number has been correctly guessed or if all candidates have been eliminated.
   */
  public boolean isOver() {

    // TODO
    return gameOver;
  }

  /**
   * Returns the guess number and adds it to the list of prior guesses.
   */
  public int getGuess() {
    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i]) {
        index = i + 1000;
        guesses[ctrguess++] = index;
        return index;
      }
    }
    return 1000;
    // TODO: add guess to the list of prior guesses.

  }

  private boolean search(int arr[], int q) {
    for (int j = 0; j < candidates.length; j++) {
      if (arr[j] == q)
        return true;
    }
    return false;
  }

  /**
   * Updates guess based on the number of matches of the previous guess. If
   * nmatches is 4, the previous guess is correct and the game is over. Check
   * project description for implementation details.
   * 
   * <p>
   * Returns true if the update has no error; false if all candidates have been
   * eliminated (indicating a state of error);
   */
  public boolean updateGuess(int nmatches) {
    if (nmatches == 4) {
      gameOver = true;
    }
    int tempIndex = ctrguess;
    if (guesses[tempIndex] == 0) {
      tempIndex--;
    }
    for (int i = 0; i < candidates.length; i++) {
      if (numMatches(i + 1000, guesses[tempIndex]) != nmatches) {
        candidates[i] = false;
      }
    }
    int x = 0;
    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i] == false) {
        x++;
      }
    }
    if (x == 9000) {
      gameOver = true;
      return false;
    }
    return true;

    // TODO
  }

  /**
   * Returns the list of guesses so far as an integer array. The size of the array
   * must be the number of prior guesses. Returns null if there has been no prior
   * guess
   */
  public int[] priorGuesses() {
    if (ctrguess == 0) {
      return null;
    }
    int save[] = new int[ctrguess];
    int temp = 0;
    for (int i = 0; i < 9000; i++) {
      if (guesses[i] != 0) {
        save[temp++] = guesses[i];
      }
    }
    return save;
    // TODO

  }
}
