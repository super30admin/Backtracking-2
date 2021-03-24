//Time Complexity: O((2^n)) since 2^n subsets
//Space Complexity: O(n) asymptotically

//Code
class Solution {
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return output;
        backtracking(nums, 0, new ArrayList<>());
        return output;
        
    }
    
    private void backtracking(int[] nums, int index, List<Integer> path){
        
        //logic
        if(index >= nums.length){
            output.add(new ArrayList(path));
            return;
        }
        
        //choose
        path.add(nums[index]);
        backtracking(nums, index+1, path);
           
        //backtracking
        path.remove(path.size()-1);
        
        //do not choose
        backtracking(nums, index+1, path);
        
        
        
        
    }
}