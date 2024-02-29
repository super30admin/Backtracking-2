// https://leetcode.com/problems/palindrome-partitioning/

// Time Complexity: O(n * 2^n)
// Space Complexity: O(2^n + n)

class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s,0,new ArrayList<String>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for (int i = pivot; i <s.length(); i++) {
            String subString = s.substring(pivot, i+1);
            if (isPalindrome(subString, 0, subString.length() - 1)){
                path.add(subString);
                helper(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String subString, int start, int end){
        while (start < end)
            if(subString.charAt(start++) != subString.charAt(end--))
                return false;
        return true;
    }
}