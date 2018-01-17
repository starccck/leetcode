import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        String[] str = {"0", "23", "1"};
        Solution solution = new Solution();
        List<String> result;
        for (String s : str) {
            result = solution.letterCombinations(s);
            System.out.print(s + "  :\n" + "[");
            for (String st : result.subList(0, result.size())) {
                System.out.print("\"" + st + "\"");
            }
            System.out.println("]");
        }
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] digitsChar = {
                {' '},
                {' '},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> oldResult = new ArrayList<String>();

        if (digits.contains("0") || digits.contains("1") || digits.contains("*") || digits.contains("#"))
            return result;

        int loc = 0;
        for (int i = 0; loc < digits.length() && i < digitsChar[digits.charAt(loc) - '0'].length; ++i) {
            result.add(String.valueOf(digitsChar[digits.charAt(loc) - '0'][i]));
            //System.out.print(String.valueOf(digitsChar[digits.charAt(0) - '0'][i]) + " ");
        }
        //System.out.println();

        for (int i = loc + 1; i < digits.length(); ++i) {
            oldResult.clear();
            oldResult.addAll(result.subList(0, result.size()));
            result.clear();
            for (String str : oldResult.subList(0, oldResult.size())) {
                for (char ch : digitsChar[digits.charAt(i) - '0']) {
                    result.add(str + String.valueOf(ch));
                }
            }
        }

        return result;
    }
}
