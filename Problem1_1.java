//Time Complexity: O(2^n)
//Space Complexity: O(2^n); new ArrayList created at every call.
//Code run successfully on LeetCode.

public class Problem1_1 {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null|| nums.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        helper(nums, 0 , new ArrayList<>());
        return result; 
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        
        if(index == nums.length){
            result.add(path);
            return;
        }
            
        //do not choose
        helper(nums, index +1, path);
        
        List<Integer> newList = new ArrayList<>(path);
        newList.add(nums[index]);
        
        
        //choose
        helper(nums,index + 1, newList);
    }
}
