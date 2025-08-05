//Time Complexity: O(2ⁿ × n) – There are up to 2ⁿ possible partitions, and checking if a substring is a palindrome takes O(n) time.
//Space Complexity: O(n) – Due to the recursion stack and the temporary path list (each path stores at most n substrings for a string of length n).

//Use backtracking to explore all substring partitions from a pivot point.
//For each substring, if it’s a palindrome, include it in the current path.
//Add the path to the result once the entire string is consumed with only valid palindromic partitions.

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, 0, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, int i, int size, List<String> path){
        if(i == s.length()){
            if(size == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //no choose
        helper(s, pivot, i+1, size, path);

        //choose
        String subStr = s.substring(pivot, i+1);
        if(isPalindrome(subStr)){
            //action
            path.add(subStr);
            //recurse
            helper(s, i+1, i+1, size + subStr.length(), path);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}
