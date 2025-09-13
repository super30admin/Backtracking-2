// Time Complexity : O(n*2^n) (each element can be chosen or not, and for each result we copy all the path to result)
// Space Complexity : O(n) (path can be at max n length, and result can have 2^n subsets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In for loop recursion, we iterate from pivot to end of string and check if substring is palindrome, if yes we add it to path and call recursion for next index
//  We only proceed to the next index if the substring is a palindrome
// In 0-1 recursion, we have 2 choices at each index, either we partition from pivot to i or we dont. We only add to the result if pivot reaches end because that means we have included all characters

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        helper(s,0,new ArrayList());
        return result;
    }

    private void helper_ForLoopRecursion(String s, int pivot, List<String> path){
        if(pivot == s.length())
            result.add(new ArrayList(path));
        
        for(int i=pivot;i<s.length();i++){
            String str = s.substring(pivot,i+1);
            if(isPalindrome(str)){
                path.add(str);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private void helper_01Recursion(String s, int pivot, int i, List<String> path){
        if(i==s.length()){
            if(pivot == s.length())
                result.add(new ArrayList(path));
            return;
        }

        //dont chose to partition
        helper(s,pivot,i+1,path);

        //partion
        String str = s.substring(pivot,i+1);
        if(isPalindrome(str)){
            path.add(str);
            helper(s,i+1,i+1,path);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int i=0; int n = s.length()-1;
        while(i<n){
            if(s.charAt(i++) != s.charAt(n--)) return false;
        }
        return true;
    }
}