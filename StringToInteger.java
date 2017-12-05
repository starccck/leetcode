/*
 *Implement atoi to convert a string to an integer.

 *Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 *Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 *Update (2015-02-10):
 *The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
Class Solution {
	public int myAtoi(String str) {
		int result = 0, loc = 0, sign = 1;
		if (str.length() == 0) {
			return 0;
		}
		while (loc < str.length() && str.charAt(loc) == ' ') {
			loc++;
		}

		if (str.charAt(loc) == '+' || str.charAt(loc) == '-') {
			if (str.charAt(loc) == '-') {
				sign = -1;
			}
			loc++;
		}

		if ( loc < str.length() && ((str.charAt(loc) >= 'a' && str.charAt(loc) <= 'z') || (str.charAt(loc) >= 'A' && str.charAt(loc) <= 'Z')))
			return 0;

		while (loc < str.length() && str.charAt(loc) >= '0' && str.charAt(loc) <= '9') {
			if ((result == Integer.MAX_VALUE / 10 && str.charAt(loc) - '0' > 7) || result > Integer.MAX_VALUE / 10) {
				if (sign == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
		}
		result = result * 10 + (str.charAt(loc++) - '0');
	}

	return result * sign;
	}
}
