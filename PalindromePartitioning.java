//TC : O(2^N) 
 //SC : O(N) // where N is the max stack size of the recurrsion  
 //run successfully on Leetcode 
 //no problems in solving

 import java.util.*;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    public void helper(String s, int index, List<String> tempList){
        if (index == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i=index; i<s.length(); i++){
                String temp = s.substring(index,i+1);
                if (isPalindrome(temp)){
                    tempList.add(temp);
                    helper(s, i+1, tempList);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}  
