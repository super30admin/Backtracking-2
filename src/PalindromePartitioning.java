// Time Complexity:           O(n * 2^n)
// Space Complexity:          O(n)
// where n is length of given String
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

// ****************************** for loop backtrack with index parameter ******************************

class Solution {

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;

    }

    private void helper(String s, int index, List<String> path) {

        // base
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for loop
        for(int i=index; i<s.length(); i++) {                        // for string "aaba"

            String sub = s.substring(index, i+1);                    // getting substrings "a", "aa", "aab" & "aaba" 

            if(isPalindrome(sub)) {                                  // if it is palindrome
                path.add(sub);                                       // add it in path
                helper(s, i+1, path);                                // recursive call for following characters with following index
                path.remove(path.size()-1);                          // backtrack
            }

        }

    }

    private boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) 
                return false;
            start++;
            end--;
        }
        return true;

    }
}






// ****************************** for loop backtrack without index parameter ******************************


// Time Complexity:  O(n * 2^n)
// Space Complexity: O(n)

class Solution {

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        helper(s, new ArrayList<>());
        return result;

    }

    private void helper(String s, List<String> path) {

        if(s.length() == 0) {                                   // reached end of the string
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0; i<s.length(); i++) {                       // for string "aab"
            String sub = s.substring(0, i+1);                   // getting "a", "aa" & "aab"
            if(isPalindrome(sub)) {                             // if they are palindrome
                path.add(sub);                                  // then add in path
                helper(s.substring(i+1), path);                 // recursive for "ab", "b" & "".
                path.remove(path.size()-1);                     // remove from path
            }
        }

    }

    private boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) 
                return false;
            start++;
            end--;
        }
        return true;

    }
}
