// Time Complexity: O(2^n)
// Space complexity: O(2^n)
import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    List<List<String>> result;
    public List<List<String>> palindromePartition(String s){
        this.result = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;

    }

    private void helper(String s, int pivot, List<String> currentPath){

        // base case

        if(pivot == s.length()){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // for loop to generate all possible substrings from start
        for(int i = pivot; i < s.length(); i++){
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)){
            currentPath.add(subStr); // add the substring to current partition
            // recurse
            helper(s, i+1, currentPath);

            //backtrack
            currentPath.remove(currentPath.size() - 1);
        }

    }

}
  private boolean isPalindrome(String str){
    int left =0;
    int right = str.length() - 1;

    while(left < right){
        if(str.charAt(left) != str.charAt(right)){
            return false;

        }
        left ++;
        right --;
    }
    return true;
  }
public static void main(String[] args){
    PalindromePartition solution = new PalindromePartition();
    String s =  "abaa";
    System.out.println(solution.palindromePartition(s));
}

  }
