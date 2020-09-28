// Time Complexity : O(n^n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList();
        List<String> path = new ArrayList();
        
        backtracking(output,s,0,path);
        
        return output;
    }
    
    public void backtracking(List<List<String>>output, String s, int index, List<String>path){
        if(index>=s.length()){
            output.add(new ArrayList(path));
        }
        
        for(int i=index;i<s.length();i++){
            String temp = s.substring(index,i+1);
            if(isPalindrome(temp)){
                path.add(temp);
                backtracking(output,s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String current){
        int left=0;
        int right=current.length()-1;
        
        while(left<right){
            if(current.charAt(left)!=current.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}