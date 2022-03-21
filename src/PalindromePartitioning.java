// Time Complexity:           O(n * 2^n)
// Space Complexity:          O(n)
// where n is length of given String
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        SolutionPalindromePartitioning obj = new SolutionPalindromePartitioning();
        System.out.println(obj.partition("aab"));
    }
}

class SolutionPalindromePartitioning {

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        partition(s, 0, new ArrayList<>());
        return result;
    }

    private void partition(String s, int index, List<String> list) {
        if(index == s.length()) {
            result.add(new ArrayList<>(list));
        }

        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i+1);
            if(isPalindrome(sub)) {
                // ACTION
                list.add(sub);
                // RECURSION
                partition(s, i+1, list);
                // BACKTRACKING
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
