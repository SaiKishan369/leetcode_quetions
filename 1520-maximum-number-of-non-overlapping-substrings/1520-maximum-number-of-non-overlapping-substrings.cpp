class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        int n = s.size();

        vector<int> first(26, n);
        vector<int> last(26, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s[i] - 'a';

            first[c] = min(first[c], i);
            last[c] = i;
        }

        vector<pair<int, int>> intervals;

        // Try every possible starting position
        for (int i = 0; i < n; i++) {

            int c = s[i] - 'a';

            // Must start at first occurrence
            if (first[c] != i)
                continue;

            int L = i;
            int R = last[c];

            bool valid = true;

            for (int j = L; j <= R; j++) {

                int x = s[j] - 'a';

                // This character occurs before L
                if (first[x] < L) {
                    valid = false;
                    break;
                }

                // Need to include all occurrences of x
                R = max(R, last[x]);
            }

            if (valid) {
                intervals.push_back({L, R});
            }
        }

        // Earliest finishing interval first
        sort(intervals.begin(), intervals.end(),
             [](const auto& a, const auto& b) {
                 return a.second < b.second;
             });

        vector<string> ans;

        int lastEnd = -1;

        for (auto [L, R] : intervals) {

            if (L > lastEnd) {
                ans.push_back(s.substr(L, R - L + 1));
                lastEnd = R;
            }
        }

        return ans;
    }
};