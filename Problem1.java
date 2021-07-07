/**
LeetCode Submitted : YES
Time Complexity : O(2^nums.length)
Space Complexity : O(1)

The idea is to recursively add all the elements of the nums array in the final result and then backtrack to remove last element and perform the same operation with remaining element.

**/



class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
     
        if(nums == null || nums.length < 1)
            return results;
        
        int index = 0;
        powerset(nums, index,new ArrayList<>());
        return results;
    }
    
    private void powerset(int[] nums, int index, List<Integer> temp){
        //Index Out of bounds Error
        if(index > nums.length)
            return;
        
        //Add to the resultant array
        results.add(new ArrayList<>(temp));
        
        //iterate the all the possible index of the array
        for(int i = index; i<nums.length;i++){
            temp.add(nums[i]);
            powerset(nums,i+1,temp);
            //backtrack remove the last element from temp array
            temp.remove(temp.size() -1);
        }
    }
    
}
