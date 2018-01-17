import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class TripleSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        long time = System.nanoTime();

        System.out.println(System.nanoTime() - time);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int numsLen = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < numsLen - 2; ++i) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = numsLen - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) ++lo;
                        while (lo < hi && nums[hi] == nums[hi - 1]) --hi;
                        ++lo;
                        --hi;
                    } else if (nums[lo] + nums[hi] < sum) {
                        ++lo;
                    } else {
                        --hi;
                    }
                }
            }
        }
        return result;
    }
}