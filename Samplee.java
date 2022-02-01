// Time Complexity :O(2 ^ n) where n is the length of the array
// Space Complexity :O(2 ^ n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int [] nums, int index,List<Integer> path){
        //base
       result.add(new ArrayList<>(path));
        
        //logic
        for(int i = index;i<nums.length;i++){
            //List<Integer> temp = new ArrayList<>(path);
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

// Time Complexity :O(2 ^ n) where n is the length of the array
// Space Complexity :O(2 ^ n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    private void helper(String s,int index,List<String> path){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
        }
        for(int i = index;i <s.length();i++){
            String sub = s.substring(index,i+1);
            if(palindrome(sub)){
            path.add(sub);
            helper(s,i+1,path);
            path.remove(path.size()-1);
            }
            
        }
    }
    private boolean palindrome(String s){
        char [] c = new char[s.length()];
        for(int i = 0;i<s.length();i++){
            c[i] = s.charAt(i);
        }
        int start = 0;
        int end =c.length -1;
        while(start < end){
            if(c[start] == c[end]){
                start++;
                end--;
            }else
                return false ;
            
        }
       return true;
    }
    
}
