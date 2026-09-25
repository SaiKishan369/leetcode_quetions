class Solution {

    private int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parse(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();

        // Empty string is the identity for concatenation
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            char ch = s.charAt(i);

            if (ch == ',') {

                // Finish current term
                result.addAll(current);

                current.clear();
                current.add("");

                i++;

            } else {

                Set<String> part;

                if (ch == '{') {

                    i++; // skip '{'

                    part = parse(s);

                    i++; // skip '}'

                } else {

                    part = new HashSet<>();
                    part.add(String.valueOf(ch));

                    i++;
                }

                // Concatenate current with part
                Set<String> next = new HashSet<>();

                for (String a : current) {
                    for (String b : part) {
                        next.add(a + b);
                    }
                }

                current = next;
            }
        }

        // Add the final term
        result.addAll(current);

        return result;
    }
}