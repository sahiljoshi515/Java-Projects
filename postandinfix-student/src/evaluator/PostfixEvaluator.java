package evaluator;

import parser.ArithParser;
import stack.LinkedStack;

public class PostfixEvaluator extends Evaluator {

  private LinkedStack<Integer> stack = new LinkedStack<Integer>();

  /** return stack object (for testing purpose). */
  public LinkedStack<Integer> getStack() {
    return stack;
  }

  String[] signs = { "+", "-", "*", "/", "!" };

  /**
   * This method performs one step of evaluation of a postfix expression. The
   * input is a token. Follow the postfix evaluation algorithm to implement this
   * method. If the expression is invalid, throw an exception with the
   * corresponding exception message.
   */
  public void evaluate_step(String token) throws Exception {
    if (isOperand(token)) {
      // TODO: What do we do if the token is an operand?

      stack.push(Integer.parseInt(token));
    } else {
      /*
       * TODO: What do we do if the token is an operator? If the expression is
       * invalid, make sure you throw an exception with the correct message
       */

      if (token.equals("+")) {
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num2 = stack.pop();
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num1 = stack.pop();
        stack.push(num2 + num1);
      } else if (token.equals("-")) {
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num2 = stack.pop();
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num1 = stack.pop();
        stack.push(num1 - num2);
      } else if (token.equals("*")) {
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num2 = stack.pop();
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num1 = stack.pop();
        stack.push(num2 * num1);
      } else if (token.equals("/")) {
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num2 = stack.pop();
        if (stack.top() == null)
          throw new Exception("too few operands");
        int num1 = stack.pop();
        if (num2 == 0)
          throw new Exception("division by zero");
        stack.push(num1 / num2);
      } else if (token.equals("!")) {
        if (stack.top() == null)
          throw new Exception("too few operands");
        stack.push(-stack.pop());
      } else {
        throw new Exception("invalid operator");
      }

    }
  }

  /**
   * This method evaluates a postfix expression (defined by expr) and returns the
   * evaluation result. It throws an Exception if the postfix expression is
   * invalid.
   */
  public Integer evaluate(String expr) throws Exception {
    for (String token : ArithParser.parse(expr)) {
      evaluate_step(token);
    }
    // The stack should have exactly one operand after evaluation is done
    if (stack.size() > 1) {
      throw new Exception("too many operands");
    } else if (stack.size() < 1) {
      throw new Exception("too few operands");
    }
    return stack.pop();
  }

  public static void main(String[] args) throws Exception {
    System.out.println(new PostfixEvaluator().evaluate("50 25 ! / 3 +"));
  }
}