import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {
    public static void main(String[] args) {
        String[] roman = {"DCXLV", "DCCXIX", "I", "MMMCCXCIX", "MMMCMXCIX", "CMLII"};
        Integer[] value = {645, 719, 1, 3299, 3999, 952};
        Solution solution = new Solution();
        long time;
        int key;
        for (String str : roman) {
            time = System.nanoTime();
            key = solution.romanToInt(str);
            System.out.println("time: " + (System.nanoTime() - time) + " " + key);
            time = System.nanoTime();
            key = solution.romanToInt1(str);
            System.out.println("time: " + (System.nanoTime() - time) + " " + key);
            time = System.nanoTime();
            key = solution.romanToInt2(str);
            System.out.println("time: " + (System.nanoTime() - time) + " " + key);
        }
    }
}

class Solution {
    public int romanToInt(String s) {
        //String [] symbol = {"M","D","C","L","X","V","I"};
        //int [] value = {1000,500,100,50,10,5,1};
        Map<String, Integer> romanValue = new HashMap<String, Integer>();
        romanValue.put("M", 1000);
        romanValue.put("D", 500);
        romanValue.put("C", 100);
        romanValue.put("L", 50);
        romanValue.put("X", 10);
        romanValue.put("V", 5);
        romanValue.put("I", 1);

        char[] str = s.toCharArray();
        int strLen = str.length;
        int lastValue = 0;
        int currentValue = 0;
        int value = 0;

        if (strLen < 1)
            return 0;

        lastValue = getValue(str[0]);
        value += lastValue;

        for (int i = 1; i < strLen; ++i) {
            currentValue = romanValue.get(String.valueOf(str[i]));
            value += currentValue;

            if (lastValue < currentValue) {
                for (int j = i - 1; j >= 0 && romanValue.get(String.valueOf(str[j])) < currentValue; --j) {
                     value -= romanValue.get(String.valueOf(str[j])) * 2;
                }
            }
            lastValue = currentValue;
        }

        return value;
    }

    public int romanToInt1(String s) {
        char[] str = s.toCharArray();
        int strLen = str.length;
        int lastValue = 0;
        int currentValue = 0;
        int value = 0;

        if (strLen < 1)
            return 0;

        int i = 1;
        lastValue = getValue(str[0]);
        value += lastValue;
        while (i < strLen) {
            currentValue = getValue(str[i]);
            value += currentValue;

            if (lastValue < currentValue) {
                for (int j = i - 1; j >= 0 && getValue(str[j]) < currentValue; --j) {
                    value -= getValue(str[j]) * 2;
                }
            }
            lastValue = currentValue;
            ++i;
        }

        return value;
    }
    int getValue(char s) {
        switch (s) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }

    public int romanToInt2(String s) {
        char[] str = s.toCharArray();
        int strLen = str.length;
        int lastValue = 0;
        int currentValue = 0;
        int value = 0;

        if (strLen < 1)
            return 0;

        int i = 1;
        lastValue = getValueIF(str[0]);
        value += lastValue;
        while (i < strLen) {
            currentValue = getValueIF(str[i]);
            value += currentValue;

            if (lastValue < currentValue) {
                for (int j = i - 1; j >= 0 && getValueIF(str[j]) < currentValue; --j) {
                    value -= getValueIF(str[j]) * 2;
                }
            }
            lastValue = currentValue;
            ++i;
        }

        return value;
    }

    int getValueIF(char s) {
        if (s == 'M') {
            return 1000;
        } else if (s == 'D') {
            return 500;
        } else if (s == 'C') {
            return 100;
        } else if (s == 'L') {
            return 50;
        } else if (s == 'X') {
            return 10;
        } else if (s == 'V') {
            return 5;
        } else if (s =='I') {
            return 1;
        }
        return 0;
    }
}