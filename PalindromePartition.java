//Time Complexity : O(2^n)
//Space Complexity : O(n)
import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s== null || s.length() == 0) return result;
        backtracking(s,0,new ArrayList<>());
        return result;

    }
    private void backtracking(String s , int start, List<String> temp){
        //base
        if(start >= s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        //logic
        for(int i = start; i < s.length();i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start, i+1));
                backtracking(s, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int left, int right){
        int l = left,r=right;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
    public static void main(String args[]){
        PalindromePartition obj = new PalindromePartition();
        System.out.println(obj.partition("aab"));
    }
}