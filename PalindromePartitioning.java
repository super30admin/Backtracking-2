/*
Time Complexity -  O(N * 2 ^ N)
                   Let N be length of the input string 's'.
                   In the worst case when all possible substrings in 's' are palindrome, then the number of operations is equal to 2 ^ N. 
                   O(N) time to generate the substring and to check if it is a palindrome.
        
Space Complexity - O(N) stack space for recursion.
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> substr = new LinkedList<String>();
        createSubStr(s, 0, substr, result);
        return result;
    }

    public void createSubStr(String s, int start, LinkedList<String> substr, List<List<String>> result) {

        if(start >= s.length())
            result.add(new ArrayList<String>(substr));

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) 
            {
                substr.add(s.substring(start, end + 1));
                createSubStr(s, end + 1, substr, result);
                substr.removeLast();
            }
        }  
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) 
                return false;
        return true;
    }
} 
