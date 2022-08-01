//Time Complexity: O(2^n)
//Space Complexity: O(n); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem1_2 {

    List<List<Integer>> result;
    List<Integer> path;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null|| nums.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        path = new ArrayList<>();
        
        helper(nums, 0);
        return result;
    }
    
    private void helper(int[] nums, int index){
        
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //do not choose
        helper(nums, index + 1);
        
        //choose
        path.add(nums[index]);
        helper(nums, index+1);
        path.remove(path.size() -1);
    }
}
