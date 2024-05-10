import java.util.ArrayList;
import java.util.List;

 // TC: O(2^n)
public class Problem2{
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    public void helper(String s, int pivot, List<String> path){
        //base
        if(pivot==s.length()){
            List<String> li = new ArrayList<>(path);
            result.add(li);
            return;
        }

        //logic
        for(int i=pivot;i<s.length();i++){
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)){
                path.add(subStr);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
        
    }

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            else
                i++;
                j--;
        }
        return true;
    }
}