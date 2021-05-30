
import java.util.*;
//TC: N*2(N) - For Palindrom it will be N and for backtrack it will be N(2)
//SC:O(M*N) - Recursive stack space
public class PalindromePartioning {

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if (s == null || s.length() == 0)
            return result;
        helper(s, new ArrayList(), 0);
        return result;
    }

    private void helper(String s, List<String> path, int index) {
        if(index == s.length()){
            result.add(new ArrayList(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String currentString = s.substring(index, i+1);
            if(isPalindrome(currentString)) {
                path.add(currentString);
                System.out.println(currentString);
                helper(s, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String word) {
        int leftPointer = 0;
        int rightPointer = word.length()-1;
        while(leftPointer < rightPointer) {
            if(word.charAt(leftPointer) == word.charAt(rightPointer)) {
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartioning palindromePartioning = new PalindromePartioning();
        List<List<String>> result = palindromePartioning.partition("aab");
        System.out.println(result);
    }
}