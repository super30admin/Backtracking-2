import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s==null || s.length()==0) return result;

        helper(s, new ArrayList<>(), 0);
        return result;

    }

    private void helper(String s, List<String> temp, int index) {

        //base
        if(index==s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        //logic
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                //action
                temp.add(s.substring(index,i+1));
                //recursion
                helper(s, temp, i+1);
                //backtrack
                temp.remove(temp.size()-1);

            }
        }
    }

    private boolean isPalindrome(String s, int index, int i) {
        while(index<=i){
            if(s.charAt(index)!=s.charAt(i)){
                return false;
            }
            i--;
            index++;
        }
        return true;
    }
}
