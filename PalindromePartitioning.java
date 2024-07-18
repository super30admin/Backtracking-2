import java.util.ArrayList;
import java.util.List;

//Approach - for loop based recursion backtracking
//time - O(N*2N), Space - O(n)
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, int index, List<String> path) {
        //base
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                backtrack(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}