// Time Complexity : The time complexity is  exponential since at every recursive call we are making subsets
// Space Complexity : The space complexity is O(n) where n is the length of the string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    List<List<String>> output;

    public List<List<String>> partition(String s) {

        output = new LinkedList<>();

        if(s == null || s.length() == 0){
            return output;
        }

        backTrack(s,0,new LinkedList<>());

        return output;

    }

    public void backTrack(String s,int index,List<String> partition){

        if(index == s.length()){
            output.add(new LinkedList<>(partition));
        }

        for(int i=index;i<s.length();i++){

            // If subset is a palindrome
            if(isPalindrome(s,index,i)){
                // action
                partition.add(s.substring(index,i+1));
                // recursion
                backTrack(s,i+1,partition);
                //backtrack
                partition.remove(partition.size()-1);
            }
        }
    }

    // Check is the string is a palindrome
    public boolean isPalindrome(String s,int start,int end){

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}