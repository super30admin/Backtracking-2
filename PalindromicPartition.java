// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class PalindromicPartition {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        helper(s, 0, new ArrayList());
        return result;
    }
    private void helper(String s, int pivot, List<String>path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot; i<s.length();i++){
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                //action
                path.add(sub);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);

            }
            
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}