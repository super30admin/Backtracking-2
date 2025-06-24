import java.util.ArrayList;
import java.util.List;

/* For Loop Recursive solution
Time complexity - O(2^N) * N
O(2^N) this many recursive paths  to generate substrings
N(to check palindrome)
Space complexity -  O(N) - recursive stack + to store results */
public class PalindromePartitioning_LC_139 {
    List<List<String>> output;
    public List<List<String>> partition(String str){
        if(str == null || str.length()==0) {
            return new ArrayList<>();
        }
        output = new ArrayList<>();
        helper(str, 0,new ArrayList<>());
        return output;
    }

    private  void helper(String str, int index, List<String> tmp) {
        //Termination condition
        if (index == str.length()) {
            output.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            String currPart = str.substring(index, i+1);
            if (isValidPalindrome(currPart, 0, currPart.length()-1)) {
                tmp.add(currPart);
                helper(str, i + 1, tmp);  //Exploring
                tmp.remove(tmp.size()-1);  //unchoosing

            }
        }
    }

    private  boolean isValidPalindrome(String str, int start, int end){
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
