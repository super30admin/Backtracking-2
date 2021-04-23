//Time complexity:O(2^n)
//checking the nums array is empty
//calling the helper function
//In the helper function iterating through the array and then making recursive calls and then removing it inorder to backtrack
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<>();
        if(nums.length==0 || nums==null){
            return result;
        }
        helper(nums,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums,int index, List<Integer>path){
        //base
        
            result.add(new ArrayList<>(path));
        
        
       for(int i=index;i<nums.length;i++){
           path.add(nums[i]);
           helper(nums,i+1,path);
           path.remove(path.size()-1);
       }
        
        
    }
}

//BACKTRACKING
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<>();
        if(nums.length==0 || nums==null){
            return result;
        }
        helper(nums,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums,int index, List<Integer>path){
        //base
        if(index==nums.length){
            result.add(path);
            return;
        }
        //logic
        helper(nums,index+1,new ArrayList<>(path));
        path.add(nums[index]);
        helper(nums,index+1,new ArrayList<>(path));
        
        
    }
}