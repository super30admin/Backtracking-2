// TIME: O(2^N)
// SPACE: O(N)
// SUCCESS on LeetCode

public class PalindromePartitioning {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return answer;
    }
    
    private void helper(String s, int pivot, List<String> path) {
        // base case
        if (pivot == s.length()) {
            System.out.println(path.toString());
            answer.add(new ArrayList<>(path));
            return;
        };
        
        // logic
        for (int i = pivot; i < s.length(); i++) {
            // action
            String curr = s.substring(pivot, i+1);
            if (isPalindrome(curr)) {
                path.add(curr);
                // recurse
                helper(s, i + 1, path);
            
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}
