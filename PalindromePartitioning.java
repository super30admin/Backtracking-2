/**
 * LeetCode Execution: Smooth
 * 
 * Time Complexity: 
 * Space Complexity: 
 * 
 */

class Solution {
  public List<List<String>> partition(String s) {
  List<List<String>> ret = new ArrayList<>();
  dfs(s, 0, new ArrayList<>(), ret);
  return ret;
}

private void dfs(String s, int idx, List<String> path, List<List<String>> ret) {
  if (idx == s.length()) {
      ret.add(path);
      return;  // backtracking
  }
  for (int i=idx+1; i <= s.length(); i++) {
      if (isPalin(s.substring(idx, i))) {
          List<String> p = new ArrayList<>(path);
          p.add(s.substring(idx, i));
          dfs(s, i, p, ret);
      }
  }
}

private boolean isPalin(String s) {
  int l = 0, r = s.length()-1;
  while (l < r) {
      if (s.charAt(l++) != s.charAt(r--)) {
          return false;
      }
  }
  return true;
}
}