//Backtracking
//Time Complexity - O(N x 2^N) - where N is the length of the string s
//Space Complexity - O(N)


class Solution {

  List<List<String>> result;
  public List<List<String>> partition(String s) {

    result = new ArrayList<>();

    if(s == null || s.length() == 0){
      return result;
    }
    backtrack(s, new ArrayList<>(), 0);

    return result;
  }


  public void backtrack(String s, List<String> path, int index){

    if(index == s.length()){
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i=index; i<s.length(); i++){
      if(isPalindrome(s, index, i)){
        String word = s.substring(index, i+1);
        path.add(word);
        backtrack(s, path, i+1);
        path.remove(path.size()-1);
      }
    }
  }



  private boolean isPalindrome(String s, int left, int right){
    if(right < left){
      return false;
    }

    while(left < right){
      if(s.charAt(left) != s.charAt(right)){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}