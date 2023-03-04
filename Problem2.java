import java.util.ArrayList;
import java.util.List;
/*
Palindrome Partitioning
approach: dfs with backtracking i.e. pivot onwards
time: O(N(2^N))
space: O(height)
 */
public class Problem2 {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s==null || s.length()==0) return res;

        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int pivot, List<String> path) {
        if(pivot==s.length()) {
            res.add(new ArrayList<>(path));
        }

        for(int i=pivot;i<s.length();i++) {
            String temp = s.substring(pivot, i+1);
            path.add(temp);
            if(isPalindrome(temp)) {
                dfs(s, i+1, path);
            }
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s) {
        int i=0, j = s.length()-1;

        while(i<=j) {
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}
