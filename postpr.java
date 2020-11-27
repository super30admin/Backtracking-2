//Time complexity-2^n
class Solution {
    //Creating a list to store the output
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        //Calling the helper function
        helper(nums,new ArrayList<>(),0);
        return result;
        
    }
    public void helper(int[] nums, List<Integer> temp,int start){
        //Adding each node of the tree to the output list 
        result.add(new ArrayList<>(temp));
        
        for(int i=start;i<nums.length;i++){
            //Adding elements into the current temp
            temp.add(nums[i]);
            helper(nums,temp,i+1);
            //Backtracking to get the proper output
            temp.remove(temp.size()-1);
        }
    }
}