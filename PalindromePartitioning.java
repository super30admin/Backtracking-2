/**
 * time complexity is 2^N - becuase of 2^N possible partitions
 * space complexity is exponential
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int idx, List<String> partitions) {
        if(idx == s.length()) {
            result.add(new ArrayList<>(partitions));
            return;
        }
        
        for(int i = idx; i < s.length(); i++) {
            String substr = s.substring(idx, i+1);
            if(isPalindrome(substr)) {
                partitions.add(substr);
                helper(s, i+1, partitions);
                partitions.remove(partitions.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}