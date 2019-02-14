class Solution {
	public long solution(int a, int b) {
		long sum = 0;
		int first = a > b ? b : a;
		int last = a == b ? a : a > b ? a : b;

		for(int i = first; i <= last; i++) {
			sum += i;
		}

		return sum;
	}
}