package com.training.assignment4;

public final class BracketValidator {
    private BracketValidator() {
    }

    public static boolean isValid(String expression) {
        if (expression == null) {
            return false;
        }

        GenericStack<Character> stack = new GenericStack<Character>(expression.length() + 1);
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty() || !matches(stack.pop(), character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }
}
