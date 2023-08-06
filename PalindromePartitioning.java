import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    //Using for loop approach
    // Time complexity = O(2^n)
    //Space complexity = 0(n);
    class SolutionUsingForLoop {
        List<List<String>>result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            helper(s, 0, new ArrayList<>());
            return result;
        }

        public void helper(String s, int pivot, List<String> path){
            if(pivot == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for(int i = pivot; i<s.length(); i++){
                String sub = s.substring(pivot, i+1);
                if(isPalindrome(sub)){
                    path.add(sub);
                    helper(s, i+1, path);
                    path.remove(path.size()-1);
                }
            }
        }

        public boolean isPalindrome(String s){
            int start = 0;
            int end = s.length()-1;
            while(start<end) {
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    //Using 01 recursion approach
    // Time complexity = O(2^n)
    //Space complexity = 0(n);
    class SolutionUsing01Recursion {
        List<List<String>>result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            helper(s,0,0,new ArrayList<>(),0);
            return result;
        }

        public void helper(String s, int pivot, int i, List<String> path, int sum){
            if(i==s.length()){
                if(sum==s.length()){
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s,i+1, i+1,path, sum + sub.length());
                path.remove(path.size()-1);
            }
            helper(s,pivot,i+1,path,sum);
        }

        public boolean isPalindrome(String s){
            int start = 0;
            int end = s.length()-1;
            while(start<end) {
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
