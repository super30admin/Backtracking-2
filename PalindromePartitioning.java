// Time Complexity : O(n*(2^n))
// Space Complexity : O(n) The max height of the stack will be the length of the string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) return result;
        
        helper(result, s, new ArrayList<>(), 0);
        
        return result;
    }
    
    public void helper(List<List<String>> result, String s, List<String> path, int index){
        
        // base case
        // When index reached the end of the string we have generated all possible palindrome in the path variable.
        if(index == s.length()){
            // Since path is a reference variable, create new array list from the path and add it to the result.
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // Start off with the index 0. 
        // Generate all substring starting from the input index to length of the string.
        for(int i = index; i < s.length(); i++){
            // Check if the selected substring starting at index and ending i is palindrome. 
            if(isPalindrome(s, index, i)){
                // action
                // If the picked substring is palindrome then add it to the path variable.
                path.add(s.substring(index, i+1));
                // recurse
                // Recurse on the rest of the substring to find all the possible palindromes.
                helper(result, s, path, i+1);
                // backtrack
                // Finally undo the action of adding the substring to the path variable.
                path.remove(path.size()-1);
            }
        }
    }
    
    // Function to check if a given string is palindrome from given index l --> r.
    public boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        
        while(l <= r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        
        return true;
    }
    
}
