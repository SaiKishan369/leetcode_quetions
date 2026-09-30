class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int[] answer = new int[seq.length()];

        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {

            if (seq.charAt(i) == '(') {

                depth++;

                // Odd depth -> group 0
                // Even depth -> group 1
                answer[i] = depth % 2;

            } else {

                // Closing bracket belongs to the
                // same group as its matching opening bracket
                answer[i] = depth % 2;

                depth--;
            }
        }

        return answer;
    }
}