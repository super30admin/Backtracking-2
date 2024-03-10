package week6.day2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(s, 0, path);
        return result;
    }
    private void helper(String s, int pivot,List<String> path){
        //base
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++){
            String str = s.substring(pivot, i+1);
            if(isPalindrome(str)){
                path.add(str);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
