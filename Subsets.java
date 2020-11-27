class Subsets {
    // Approach - Backtracking
    // Time complexity - exponential
    // space complexity - O(n)
    // Tested in leetcode
    
    // driver function for recursion 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,result,new ArrayList<>());
        for(List<Integer> list : result )
            System.out.println(list);
        return result;
    }
    
    // this function recurse through all posibilities, save temp arraylist which is a subset, backtrack and undo move.
    public void helper(int[] nums, int index, List<List<Integer>> result, ArrayList<Integer> temp){
        // save the subset into the result
            result.add(new ArrayList<>(temp));
        // base case - when index is pointing at length of the nums array
        if(index == nums.length)
            return;
        
        // iterate through all element of the nums, save the current element into the subset and recurse for next subset.
        for(int i=index;i<nums.length; i++){
                temp.add(nums[i]);
            helper(nums,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}