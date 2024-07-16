//Approach: find out all the combinations and add those combinations who meet the criteria
//Time complexity:n*(2^n)
//Space complexity:o(n) as we are maintaning only single list

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path) {
        //base
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        //logic
        for(int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)) {
                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str)
    {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
}
