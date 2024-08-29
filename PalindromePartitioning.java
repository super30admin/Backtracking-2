//Time Complexity: 2 raise to the power n
//Space Complexity: O(h)
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0,  new ArrayList<>());
        return result;
    }

    public void helper(String s, int pivot, List<String> path){
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < s.length(); i++){
            String substr = s.substring(pivot, i+1);
            if(palindrome(substr)){
                path.add(substr);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean palindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
