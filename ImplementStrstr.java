public class ImplementStrstr {
    public static void main(String[] args) {
        String[] str = {"hello", "aaaaa"};
        String[] needle = {"ll", "bba"};
        Solution solution = new Solution();
        for (int i = 0; i < str.length; i++) {
            System.out.println(solution.strStr(str[i], needle[i]));
        }
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
