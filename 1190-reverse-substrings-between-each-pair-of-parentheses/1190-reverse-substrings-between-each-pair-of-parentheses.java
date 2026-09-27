class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save the string before entering parentheses
                stack.push(current.toString());
                current.setLength(0);

            } else if (ch == ')') {
                // Reverse current substring
                current.reverse();

                // Attach it to the previous level
                String previous = stack.pop();

                current.insert(0, previous);

            } else {
                // Normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}