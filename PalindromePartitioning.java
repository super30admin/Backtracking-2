/*The time complexity of this implementation is O(n)*/
import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currList.add(s.substring(start, i+1));
                backtrack(s, i+1, currList, result);
                currList.remove(currList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> partitions = solution.partition(s);
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }

}
