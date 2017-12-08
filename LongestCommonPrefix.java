/*
 *Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] word = {"abcdf", "abcfd", "abdfg"};
        Solution solution = new Solution();
	// for
        long start = System.nanoTime();
        System.out.println(solution.longestCommonPrefix(word));
        System.out.println(System.nanoTime() - start);
	// while
        start = System.nanoTime();
        System.out.println(solution.longestCommonPrefix1(word));
        System.out.println(System.nanoTime() - start);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
	int len = strs.length;
        if (len == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < len; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    public String longestCommonPrefix1(String[] strs) {
	int len = strs.length;
        if (len == 0) {
            return "";
        }
        String prefix = strs[0];
        int i = 1;
        while (i < len) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            i++;
        }
        return prefix;
    }
}
