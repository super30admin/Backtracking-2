// Time Complexity : O((N+N)(2^N)) - N: checking if its a palindrome, N for creating substrings, 2^N for creating nodes choose and not choose case
// Space Complexity : O((N+N)(2^N))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 3- For-loop based recursion using Backtracking
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        //null check
        if(s ==  null || s.length() == 0)
            return result;

        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String> path){

        //base case
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = idx ; i < s.length() ; i++){
            String sub = s.substring(idx,i+1);

            if(isPalindrome(sub)){
                //action
                path.add(sub);
                //recursion
                helper(s,i+1,path);
                //backtracking
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}

//Method 2 - For-loop based recursion using Backtracking without idx(pivot) - passing substring everytime to the recursive call
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        //null check
        if(s ==  null || s.length() == 0)
            return result;

        helper(s,new ArrayList<>());
        return result;
    }

    private void helper(String s, List<String> path){

        //base case
        if(s.length() == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = 0 ; i < s.length() ; i++){
            String sub = s.substring(0,i+1);

            if(isPalindrome(sub)){
                //action
                path.add(sub);
                //recursion
                helper(s.substring(i+1),path);
                //backtracking
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}

//Method 1 - Brute Force - Using recursion

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        //null check
        if(s ==  null || s.length() == 0)
            return result;

        helper(s,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String> path){

        //base case
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = idx ; i < s.length() ; i++){
            String sub = s.substring(idx,i+1);

            if(isPalindrome(sub)){
                List<String> temp = new ArrayList<>(path);
                temp.add(sub);
                helper(s,i+1,temp);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}

//Method 0 - Brute Force - 0-1 recursion and Backtracking
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        //null check
        if(s ==  null || s.length() == 0)
            return result;

        helper(s,0,0,new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, int i, List<String> path){

        //base case 1
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //base case 2
        if(i == s.length())
            return;

        //logic
        //not choose
        helper(s,idx,i+1,path);

        //choose
        String sub = s.substring(idx,i+1);
        if(isPalindrome(sub)){
            //action
            path.add(sub);
            //recurse
            helper(s,i+1,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}