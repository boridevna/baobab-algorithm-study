class Solution {
    public long solution(int a, int b) {
      long sum = a + b;
      long count = Math.abs(a - b) + 1;
  
      return sum * count / 2;
    }
  }