import java.util.*;

public class PalindromePartition {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s==null||s.length()==0) return result;
        helper(s,0,0,new ArrayList<>());
        return result;
    }

    private void helper(String s,int pivot,int i,List<String> path){
        //base
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        if(i==s.length()) return;
        //logic
        //not choose
        helper(s,pivot,i+1,path);
        //choose
        //action
        String substr = s.substring(pivot,i+1);
        if(isPalindrome(substr)){
            path.add(substr);
            //recurse
            helper(s,i+1,i+1,path);
            //backtrack
            path.remove(path.size()-1);

        }

    }

    private boolean isPalindrome(String s){
        int start =0;
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
