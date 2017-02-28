import java.util.Scanner;

/**
 * Created by sulu on 2/26/17.
 */
public class InfixToPostfixConvertor {

    static char plus = '+';
    static char minus = '-';
    static char multiply = '*';
    static char divide = '/';
    static char leftParaenthesis = '(';
    static char rightParaenthesis = ')';
//    char [] operatorArray = {plus, minus, multiply, divide, leftParaenthesis, rightParaenthesis};
//    char operator;

    String infix;
    String postfix;

    MyIntStack myIntStack;

    public InfixToPostfixConvertor (int max, String infix) {
        myIntStack = new MyIntStack(max);
        this.infix = infix;
    }

//    public String convertToPostfix ( ) {
//        return toPostfix(infix);
//    }

    private void toPostfix () {
        int size = infix.toCharArray().length;
        for (int i = 0; i < size; i++) {

            char currentSymbol = infix.charAt(i);
            if (isOperands(currentSymbol)) {  // if is operands than just output
                System.out.print( currentSymbol );
            }
            else {
                if ( okToPush ( currentSymbol ) ) {
                    if (!myIntStack.isFull()) {
                        myIntStack.push( (int) currentSymbol );
                    }
                }
                else if ( okToPop ( currentSymbol ) ) {
                    while ( !myIntStack.isEmpty() ) {
                        if ( currentSymbol == rightParaenthesis ) {
                            if ( (char) myIntStack.peek() != leftParaenthesis ) {
                                System.out.print ( (char) myIntStack.pop());  // if it is NOT leftParaenthesis pop and print
                            }
                            else {
                                myIntStack.pop();  // if it is leftParaenthesis just pop
                                break;
                            }
                        }
                        else {
                            if ( (char) myIntStack.peek() == leftParaenthesis ) {
                                myIntStack.push( (int) currentSymbol);  // if it is NOT leftParaenthesis pop and print
                                break;
                            }
                            else {
                                System.out.print ( (char) myIntStack.pop());  // if it is leftParaenthesis just pop
                                if (myIntStack.isEmpty()) {
                                    myIntStack.push( (int) currentSymbol);
                                    break;
                                }
                            }
                        }
                    }

                }
            }
            if (i == size - 1) {
                while (! myIntStack.isEmpty()) {
                    System.out.print ( (char)myIntStack.pop() );
                }
            }
        }
    }

    private boolean isOperands (char currentSymbol) {
        if (currentSymbol == plus || currentSymbol == minus || currentSymbol == multiply
                || currentSymbol == divide || currentSymbol == rightParaenthesis
                || currentSymbol == leftParaenthesis) {
            return false;
        }
        else {
            return true;
        }
    }


    private boolean okToPush (char currentOperator) {
//        char topOperator = (char) myIntStack.peek();
        if (myIntStack.isEmpty()
                || isCurrentAtPriority(currentOperator, (char) myIntStack.peek())
                || (char) myIntStack.peek() == leftParaenthesis) {
            return true;
        }
        else if ( currentOperator == leftParaenthesis ) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean okToPop (char currentOperator) {
        if ( !isCurrentAtPriority( currentOperator, (char) myIntStack.peek()) ) {
            return true;
        }
        else if ( currentOperator == rightParaenthesis) {
            return true;
        }
        return false;
    }

    private boolean isCurrentAtPriority (char currentOperator, char topOperator) {

        if ( getPriority(currentOperator) > getPriority(topOperator) ) {
            return true;
        }
        else {
            return false;
        }
    }

    private int getPriority (char operator) {
        if ( operator == plus || operator == minus ) {
            return 1;
        }
        else if ( operator == multiply || operator == divide) {
            return 2;
        }
        return 0;
    }

    //    private char checkOperator () {
//        return myScanner.next().charAt(0);
//    }

//    private void printThisOperand () {
//
//    }


    /**
     * Main function
     * @param args
     */
    public static void main (String [] args) {
        String infixExpression = "a+b*c+(d*e+f)*g";

        InfixToPostfixConvertor convertor1 = new InfixToPostfixConvertor(infixExpression.length(), infixExpression);
        convertor1.toPostfix();

    }
}