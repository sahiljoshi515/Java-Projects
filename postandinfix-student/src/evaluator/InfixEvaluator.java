package evaluator;

import parser.ArithParser;
import stack.LinkedStack;

public class InfixEvaluator extends Evaluator {

  private LinkedStack<String> operators = new LinkedStack<String>();
  private LinkedStack<Integer> operands = new LinkedStack<Integer>();

  /** return stack object (for testing purpose). */
  public LinkedStack<String> getOperatorStack() {
    return operators;
  }

  public LinkedStack<Integer> getOperandStack() {
    return operands;
  }

  private int ctr_lp;

  String process_operator() throws Exception {
    String sign = operators.pop();
    if (sign == null)
      throw new Exception("too few operators");
    Integer i1 = operands.pop();
    if (i1 == null)
      throw new Exception("too few operands");
    if (!(sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/") || sign.equals("!")
        || sign.equals("(") || sign.equals(")")))
      throw new Exception("invalid operator");
    Integer i2 = 99999999;
    if (!sign.contentEquals("!"))
      i2 = operands.pop();
    if (i2 == null)
      throw new Exception("too few operands");
    Integer result = null;
    switch (sign) {

    case "+":
      result = i1 + i2;
      break;
    case "-":
      result = i2 - i1;
      break;
    case "/":
      if (i1 == 0)
        throw new Exception("division by zero");
      result = i2 / i1;
      break;
    case "*":
      result = i1 * i2;
      break;
    case "!":
      result = -i1;
      break;
    }
    if (result != null)
      operands.push(result);
    return sign;

  }

  private void last_case(String token) throws Exception {
    if (!operators.isEmpty())
      if (precedence(token) <= precedence(operators.top())) {
        process_operator();
        last_case(token);
      }

  }

  /**
   * This method performs one step of evaluation of a infix expression. The input
   * is a token. Follow the infix evaluation algorithm to implement this method.
   * If the expression is invalid, throw an exception with the corresponding
   * exception message.
   */
  public void evaluate_step(String token) throws Exception {
    if (isOperand(token)) {
      // TODO: What do we do if the token is an operand?
      operands.push(Integer.parseInt(token));
    } else {
      /*
       * TODO: What do we do if the token is an operator? If the expression is
       * invalid, make sure you throw an exception with the correct message.
       * 
       * You can call precedence(token) to get the precedence value of an operator.
       * It's already defined in the Evaluator class.
       */

      if (token.equals("(")) {
        operators.push(token);
        ctr_lp += 1;
      } else if ((operators.isEmpty() || precedence(token) > precedence(operators.top())))
        operators.push(token);

      else if (token.equals(")")) {
        while (!operators.isEmpty()) {
          if (operators.top().equals("("))
            break;
          process_operator();
        }
        if (operators.isEmpty())
          throw new Exception("missing (");
        operators.pop();
      } else {
        last_case(token);
        operators.push(token);
      }

    }
  }

  /**
   * This method evaluates an infix expression (defined by expr) and returns the
   * evaluation result. It throws an Exception object if the infix expression is
   * invalid.
   */
  public Integer evaluate(String expr) throws Exception {

    for (String token : ArithParser.parse(expr)) {
      evaluate_step(token);
    }

    /* TODO: what do we do after all tokens have been processed? */
    while (!operators.isEmpty()) {
      process_operator();
    }
    // The operand stack should have exactly one operand after the evaluation is
    // done
    if (operands.size() > 1) {
      throw new Exception("too many operands");
    } else if (operands.size() < 1) {
      throw new Exception("too few operands");
    }

    return operands.pop();
  }

  public static void main(String[] args) throws Exception {
    System.out.println(new InfixEvaluator().evaluate("5+(5+2*(5+9))/!8"));
  }
}
