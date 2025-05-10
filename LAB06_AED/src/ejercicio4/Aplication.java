package ejercicio4;
import ejercicio1.StackLink;
import actividad1.ExceptionIsEmpty;

public class Aplication {

    public static String symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();
        boolean isBalanced = true;

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                try {
                    char top = stack.pop();
                    if (!matches(top, ch)) {
                        isBalanced = false;
                        break;
                    }
                } catch (ExceptionIsEmpty e) {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        return String.format("\"%-15s\"   %s", s, isBalanced);
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
