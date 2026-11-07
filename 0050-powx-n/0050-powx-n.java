
class Solution {
    public double myPow(double x, int n) {

        long power = Math.abs((long) n);

        double ans = 1.0;

        while (power > 0) {

            if (power % 2 == 1) {
                ans = ans * x;
            }

            x = x * x;
            power = power / 2;
        }

        // Take reciprocal only after calculating the power
        if (n < 0) {
            ans = 1.0 / ans;
        }

        return ans;
    }
}
