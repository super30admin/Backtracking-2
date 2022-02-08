class Solution {
     List<List<String>> output ;
  int n, k;

    public List<List<String>> partition(String s) {
    output = new ArrayList();
    n = s.length();
    //for (k = 0; k < n + 1; ++k) {
      backtrack(0, new ArrayList<String>(), s);
    //}
    return output;
  }
    
  public void backtrack(int first, List<String> curr, String s) {
    // if the combination is done
    if (first >= n) {
      output.add(new ArrayList<String>(curr));
      return;
    }
    for (int i = first; i < n; i++) {
        if(isPalindrome(s, first,i)){
            
      // add i into the current combination
      curr.add(s.substring(first, i + 1));
      backtrack(i + 1, curr, s);
      // backtrack
      curr.remove(curr.size() - 1);
        }
    }
  }
     boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
 
//time complexity- O(N*2^N)
//space complexity- O(N)