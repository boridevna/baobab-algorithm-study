import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				char a = o1.charAt(n);
				char b = o2.charAt(n);
				if(a > b) return 1;
				else if(a < b) return -1;
				return o1.compareTo(o2);
			}
		});
		return strings;
	}
}