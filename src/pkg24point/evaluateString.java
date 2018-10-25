
package pkg24point;
import java.util.Stack;

 /**
  * 
  * @author user
  */
public class evaluateString
{
    /**
     * 
     * @param expression String
     * @return double
     */
    public double evaluate(String expression)
    {   
        expression = insertBlanks(expression);
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Double> values = new Stack<Double>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
        
        for (int i = 0; i < tokens.length; i++)
        {
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        // Top of 'values' contains result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    /**
     * 
     * @param op1 char
     * @param op2 char
     * @return boolean
     */
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    /**
     * 
     * @param str String
     * @return String
     */
    public static String insertBlanks(String str){
        String result = " ";
        for (int i = 0; i < str.length(); i++){
            if ( str.charAt(i) == '(' || str.charAt(i) == ')' ||
                 str.charAt(i) == '+' || str.charAt(i) == '-' ||
                 str.charAt(i) == '*' || str.charAt(i) =='/' )
                 result += " " + str.charAt(i) + " ";
            else
                result += str.charAt(i);
        }
        return result ;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    /**
     * 
     * @param op char
     * @param b double
     * @param a double
     * @return double
     */
    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;     // problem: divide int by int
        }
        return 0;
    }
    /**
     * 
     * @param one double
     * @param two double
     * @return boolean
     */
    public static boolean closeEnough(double one, double two) {
        double eps = 0.00000001;
        return Math.abs(one-two)<eps;
    }
}

