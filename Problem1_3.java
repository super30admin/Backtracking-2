//Time Complexity: O(2^n)
//Space Complexity: O(2^n); new ArrayList created at every call
//Code run successfully on LeetCode.

public class Problem1_3 {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null|| nums.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        
        result.add(path);
        
        for(int i = index; i < nums.length; i++){
            
            List<Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            helper(nums, i +1, newList);
        }
    }
}
