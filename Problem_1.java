/*
 * Time Complexity : O(2^n)
 * Space complexity : O(n) --> if we consider stack space and n is total num of elements
 * Did it run successfully on leetcode : Yes
 * 
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
       
        if(nums.length == 0){
            return result;
        }
        
        helper(nums, new ArrayList<Integer>(), 0);
        return result;
        
    }
    
    private void helper(int[] nums, List<Integer> list, int index){
        
        //Base Case
        if(index > nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        
        result.add(new ArrayList<>(list));
        //Logic
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            helper(nums, list, i+1);
            list.remove(list.size()-1);
        }
    }
}