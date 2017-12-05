/*
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 * P A H N
 * A P L S I I G
 * Y I R
 *And then read line by line: "PAHNAPLSIIGYIR"The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 *Write the code that will take a string and make this conversion given a number of rows:

 *string convert(string text, int nRows);
 *convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".ne by line: "PAHNAPLSIIGYIR"
 *Write the code that will take a string and make this conversion given a number of rows:

 *string convert(string text, int nRows);
 *convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *Write the code that will take a string and make this conversion given a number of rows:

 *string convert(string text, int nRows);
 *convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

class Solution {
	public String convert(String s, int numRows) {
		char[] ch = s.toCharArray();
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuffer();
		}

		for (int i = 0; i < numRows; ) {
			for (int idx = 0; idx < numRows && i < s.length(); idx++) {
				sb[idx].append(ch[i++]);
			}
			for (int idx = numRows - 2; idx >= 1 && i < s.length(); idx--) {
				sb[idx].append(ch[i++]);
			}
		}

		for (int idx = 1; idx < sb.length; idx++) {
			sb[0].append(sb[idx]);
		}
		return sb[0].toString();
	}
}
