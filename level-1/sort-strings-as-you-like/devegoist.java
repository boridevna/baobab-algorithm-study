import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, Comparator.comparing(String::toString, (stringA, stringB) -> {
            char a = stringA.charAt(n);
            char b = stringB.charAt(n);

            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            return stringA.compareTo(stringB);
        }));

        return strings;
    }
}