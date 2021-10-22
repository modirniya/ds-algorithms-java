package linear.stack;

public class Main {
    static final Stack<Character> stack = new Stack<>();
    static final ArrayStack arrayStack = new ArrayStack();

    public static void main(String[] args) {
        var entry = "Parham Modirnia";
        reverse(entry);
        System.out.println(isBalanced("()([])" + entry));
        for (int i = 0; i < 16; i++){
            arrayStack.push(i);
        }
        while (arrayStack.isNotEmpty()){
            System.out.println(arrayStack.pop());
        }

    }



    private static boolean isBalanced(String expression) {
        if (expression == null) throw new IllegalArgumentException();
        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '(', '[', '{', '<' -> stack.push(ch);
                case ')', ']', '}', '>' -> {
                    if (stack.isEmpty()) return false;
                    if (ch == ')') {
                        if (stack.pop() != ch - 1) return false;
                    } else {
                        if (stack.pop() != ch - 2) return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static String reverse(String entry) {
        if (entry == null) throw new IllegalArgumentException();
        for (char ch : entry.toCharArray()) {
            Main.stack.push(ch);
        }
        StringBuilder result = new StringBuilder();
        while (!Main.stack.isEmpty()) {
            final Character character = Main.stack.pop();
            result.append(character);
        }
        return result.toString();
    }
}
