//Time Complexity: O(2^n)
//Space Complexity: O(n); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem1_4 {

    List<List<Integer>> result;
    List<Integer> path;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        
        helper(nums, 0);
        return result;
    }
    
    private void helper(int[] nums, int index){
        
        result.add(new ArrayList<>(path));
        
        for(int i = index; i < nums.length; i++){
            
            path.add(nums[i]);
            helper(nums, i+1);
            path.remove(path.size() - 1);
        }
    }
}
