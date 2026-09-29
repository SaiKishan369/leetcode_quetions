class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        // Valid parentheses strings must have even length
        if ((m + n - 1) % 2 == 1)
            return false;

        // Starting with ')' can never produce a valid string
        if (grid[0][0] == ')')
            return false;

        int maxBalance = m + n;

        vector<vector<vector<bool>>> dp(
            m,
            vector<vector<bool>>(n, vector<bool>(maxBalance, false))
        );

        // Starting cell
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                int delta = (grid[i][j] == '(') ? 1 : -1;

                for (int balance = 0; balance < maxBalance; balance++) {

                    int prevBalance = balance - delta;

                    if (prevBalance < 0 || prevBalance >= maxBalance)
                        continue;

                    bool reachable = false;

                    // From above
                    if (i > 0 && dp[i - 1][j][prevBalance])
                        reachable = true;

                    // From left
                    if (j > 0 && dp[i][j - 1][prevBalance])
                        reachable = true;

                    if (reachable)
                        dp[i][j][balance] = true;
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
};