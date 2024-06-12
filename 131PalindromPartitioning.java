// Time Complexity : n* 2^(n), n = length of array, exploring all the options.O(n) time extra for checking palindrome.
// Space Complexity :O(n), because auxillary space(path) is being keeping track of path which will be at max length of string  
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Explore all the paths using for loop based recursion and use backtracking to avoid creating deep copy of path at each level. As pivot is
// static and i is moving. At each level with new pivot and i we will be able to explore all the substrings.

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(0,s,new ArrayList<>());
        return result;
    }

    private void helper(int pivot, String s, List<String> path){
        if(pivot == s.length()){
            result.add(new ArrayList(path));
            return;
        }

        for(int i = pivot ; i < s.length() ; i++){
            String currSub = s.substring(pivot,i+1);
            if(isPalindrome(currSub)){
                path.add(currSub);
                helper(i+1, s, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;

        while( start < end ){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }

        return true;
    }
}

//01 Recursion

class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(0, 0, s, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int pivot, int i, String s, List<String> path, int count) {
        if (i == s.length()) {
            if (count == s.length()) {
                result.add(new ArrayList(path));
            }
            return;
        }

        //dont choose
        helper(pivot, i + 1, s, path, count);

        //choose
        String currSub = s.substring(pivot, i + 1);

        if (isPalindrome(currSub)){
            path.add(currSub);
            helper(i + 1, i + 1, s, path, count + currSub.length());
            path.remove(path.size() - 1);
        }

    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
