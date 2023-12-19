import java.util.ArrayList;
import java.util.List;

public class Palindrome {
  List<List<String>> result = new ArrayList<List<String>>();
  List<String> path = new ArrayList<String>();

  public List<List<String>> partition(String s) {

    helper(s, path, 0);
    return result;
  }

  private void helper(String s, List<String> path, int pivot) {

    if (pivot == s.length()) {
      result.add(new ArrayList<String>(path));
      return;
    }

    for (int i = pivot; i < s.length(); i++) {
      String sub = s.substring(pivot, i + 1);
      if (isPalindrome(sub)) {

        path.add(sub);
        helper(s, path, i + 1);
        path.remove(path.size() - 1);

      }

    }
  }

  private boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (end > start) {
      if (s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }
}

