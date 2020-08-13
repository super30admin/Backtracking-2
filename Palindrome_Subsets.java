// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0,new ArrayList<>());
        
        return output;
    }
    
    private void backtracking(String s, int start, List<String> path){
    //base case
    if(start==s.length()){
        output.add(new ArrayList<>(path));
    }
        
    //recursive case
        for(int x=start;x<s.length();x++){
            String substr = s.substring(start,x+1);
            
            if(isPalindrome(substr)){
                path.add(substr);
                
                backtracking(s,x+1,path);
                
                path.remove(path.size()-1); 
            }
        }
        
    }
    
    private boolean isPalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
}