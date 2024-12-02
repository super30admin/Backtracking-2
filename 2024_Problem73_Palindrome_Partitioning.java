//131. Palindrome Partitioning - https://leetcode.com/problems/palindrome-partitioning/description/
//Time Complexity:
//Space Complexity:

//characters between pivot and i are the palindrome strings
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        //base case
        if(s == null || s.length() == 0)
            return result;
        helper(s, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<String> path, int pivot){
        //base case
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot; i < s.length(); i++){
            //substring takes 1 extra character so i+1
            String substr = s.substring(pivot, i+1);
            if(isPalindrome(substr)){
                //action
                path.add(substr);
                //recurse
                helper(s, path, i+1);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}