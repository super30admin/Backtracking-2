//Time Complexity: Exponential
//Space Complexity: O(N) recursive stack space
import java.util.*;
	public class PalindromeSubString {
	    public static void main(String[] args) {
	      Solution s = new Solution();
	      s.partition("aaba");
	    }
	}
	class Solution {
        List<List<String>> result;

        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            helper(s, 0, new ArrayList<String>());
            return result;
        }

        public void helper(String s, int index, List<String> list) {
            if (index == s.length()) {
                result.add(new ArrayList<>(list));
                return;
            }

            //logic
            for (int i = index; i < s.length(); i++) {

                if (isPalindrome(s, index, i)) {
                    list.add(s.substring(index, i + 1));
                    helper(s, i + 1, list);
                    list.remove(list.size() - 1);
                }

            }
        }

        public boolean isPalindrome(String s, int l, int r) {
            if (l == r) {
                return true;
            }
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
            return true;
        }
    }
