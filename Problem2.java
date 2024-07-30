//Time = O(2^N)
//Space = O(2^N)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) { // If start index is at the end of the string, then we have found a valid partitioning
            result.add(new ArrayList<>(tempList)); // Add a copy of the current partitioning to the result list
        } else {
            for (int i = start; i < s.length(); i++) { // Loop over all possible substrings starting from the current index
                if (isPalindrome(s, start, i)) { // If the substring is a palindrome, add it to the current partitioning and recursively call the backtrack function
                    tempList.add(s.substring(start, i+1)); // Add the current palindrome substring to the current partitioning
                    backtrack(result, tempList, s, i+1); // Recursively call backtrack function with next start index
                    tempList.remove(tempList.size()-1); // Remove the last added element to backtrack and try the next possible substring
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) { 
            if (s.charAt(start) != s.charAt(end)) { // If the characters do not match, it means the substring is not a palindrome
                return false;
            }
            start++; // Move start index towards the middle
            end--; // Move end index towards the middle
        }
        return true; 
    }
}
