// Time Complexity : O(n*2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had to lookup s.substring method

// Your code here along with comments explaining your approach
//for loop based recursion

class Solution {
    //Result in global scope
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        //Calling helper recursively
        helper(s, 0, new ArrayList<>() );
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        //base
        //If we reach the end on the string, add the list to result
        if(pivot == s.length()) result.add(new ArrayList<>(path));

        //logic
        //For loop based recursion
        for(int i = pivot; i<s.length(); i++){
            //Creating a substring from pivot to i
            String sub = s.substring(pivot, i+1);
            //Check if the substring is a palindrome or not. If it is not, do not recurse
            if(isPalindrome(sub)){
                //Add the substring ie action
                path.add(sub);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private Boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;
        //Check palindrome by using two pointers ie start and end
        //Iterate those pointers and at any point value at start does not match value at end, return false
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}