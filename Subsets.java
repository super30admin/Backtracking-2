class Subsets {
    
    // Time Complexity: O(2^N)     (where N -> no. of elements in the array)
    // Space Complexity: O(N)
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Edge Case Checking
        if(nums == null || nums.length == 0)
            return result;
        backtracking(nums, 0, new ArrayList(), result);
        return result;
    }
    
    private void backtracking(int[] nums, int index, List<Integer> curr, List<List<Integer>> result){
        // Add the current arraylist everytime to get all possible subsets
        result.add(new ArrayList(curr));
        
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            backtracking(nums, i+1, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}