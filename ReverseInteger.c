/*
 *Given a 32-bit signed integer, reverse digits of an integer.

 *Example 1:

 *Input: 123
 *Output: 321
 *Example 2:

 *Input: -123
 *Output: -321
 *Example 3:

 *Input: 120
 *Output: 21
 *Note:
 *Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.`
 */

int reverse(int x) {
	int y = 0, origin = x, result = 0, tail;

	while (x != 0)
	{
		tail = x % 10;
		x /= 10;
		y = y * 10 + tail;
		if ((y - tail) / 10 != result)
		{
			return 0;
		}
		result = y;
	}

	return result;
}
