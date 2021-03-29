// TC - O(2^n), SC - O(n)

class Solution {
    // Create a result global variable
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // Sanity check
        if(nums.length == 0){
            return result;
        }
        // call recursive function
        backtrack(nums, 0, new ArrayList<>());
        // return 
        return result;
    }
    
    // backtrack function
    private void backtrack(int[] nums, int index, List<Integer> path){
        // add current path to result
        // There is no base condition as we need to add each path into result, if index or path size goes out of nums length, it will be checked in for loop
        result.add(new ArrayList<>(path));
        // iterate from index to nums array
        for(int i=index; i<nums.length; i++){
            // add current num to path, call recursive function, remove the last element reaches end, we will backtrack and find other routes
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}