import java.lang.Math;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 3, 9, -10, 12, -2147483648};
        int[] b = {1, 2, 10, 3, 1, -1};
        int[] r = {1, 1, 0, -3, 12, 2147483647};
        int c, i = 0;
        while (i < a.length) {
            c = solution.divide(a[i], b[i]);
            System.out.println(c + " " + (c == r[i]));
            i++;
        }
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (ldivisor > ldividend || ldividend == 0) {
            return 0;
        }

        long result = ldivide(ldividend, ldivisor);
        if (result > Integer.MAX_VALUE) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }

        return (int)result * sign;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;

        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
