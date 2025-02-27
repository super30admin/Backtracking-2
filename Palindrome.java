// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
For loop based recurssion
 */
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        List<String> path=new ArrayList<>();
        helper(s,0,path);
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        if(pivot==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i<s.length();i++){
            String currPartition=s.substring(pivot,i+1);
            if(isPalindrome(currPartition)){
                path.add(currPartition);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l=0;
        int h=s.length()-1;
        while(l<h){
            if(s.charAt(l++)!=s.charAt(h--)) return false;
        }
        return true;
    }
}

