class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                // Enter a new level
                stack.push(0);
            } 
            else {
                // Current inner score
                int innerScore = stack.pop();

                // Parent level
                int score = stack.pop();

                if (innerScore == 0) {
                    // We found ()
                    score += 1;
                } 
                else {
                    // We found (A)
                    score += 2 * innerScore;
                }

                stack.push(score);
            }
        }

        return stack.peek();
    }
}