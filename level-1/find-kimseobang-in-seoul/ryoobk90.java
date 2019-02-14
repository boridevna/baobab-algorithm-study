class Solution {
  public String solution(String[] seoul) {
      String answer = "";
      int size = seoul.length;
      int findIndex= -1;
      for(int i = 0; i < size; i++) {
          if("Kim".equals(seoul[i])) {
              findIndex = i;
              break;
          }
      }
      answer =  String.format("김서방은 %d에 있다", findIndex);
      return answer;
  }
}
