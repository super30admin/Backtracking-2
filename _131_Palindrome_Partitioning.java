/**** Method 1 ****/
//Time Complexity: O(2^n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// So we use for loop recursive method, and generate all the substrings of the string and check if the substring is palindrome or not, if it is the add the partition to list and continue with other char for string, and if we reach i the nth index the we found the a valid partition so we add to ans list. At the end return the ans list.

/**** Method 2 ****/
//Time Complexity: O(2^n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// So it is same as method 1 but instead of using a index, we slice the string and send to next recursive call. So if string s has length n, we check we the substring(0, i) is palindrome then while continuing with next recursive we can call the next remaining part of the string i.e s.substring(i,n)

import java.util.ArrayList;
import java.util.List;

public class _131_Palindrome_Partitioning {

  /**** Method 1 ****/
  public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();

    partition(0, s, new ArrayList<>(), ans);
    return ans;
  }

  private void partition(
    int i,
    String s,
    List<String> list,
    List<List<String>> ans
  ) {
    if (i == s.length()) {
      ans.add(new ArrayList<>(list));
      return;
    }

    for (int idx = i; idx < s.length(); idx++) {
      if (isPalindrome(i, idx, s)) {
        list.add(s.substring(i, idx + 1));
        partition(idx + 1, s, list, ans);
        list.remove(list.size() - 1);
      }
    }
  }

  public boolean isPalindrome(int i, int j, String s) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  /**** Method 2 ****/
  public List<List<String>> partition1(String s) {
    List<List<String>> ans = new ArrayList<>();

    partition1(s, new ArrayList<>(), ans);
    return ans;
  }

  private void partition1(String s, List<String> list, List<List<String>> ans) {
    if (s.length() == 0) {
      ans.add(new ArrayList<>(list));
      return;
    }

    for (int idx = 0; idx < s.length(); idx++) {
      if (isPalindrome(0, idx, s)) {
        list.add(s.substring(0, idx + 1));
        partition1(s.substring(idx + 1), list, ans);
        list.remove(list.size() - 1);
      }
    }
  }
}
