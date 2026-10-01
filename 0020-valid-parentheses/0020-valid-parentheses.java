class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Opening brackets
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // Closing brackets
            else {

                // No opening bracket to match
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}