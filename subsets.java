// Time Complexity is O(2^n) because for each of the n elements, you have two choices (include or exclude), resulting in 2^n subsets.
// Space Complexity is O(n) for the recursion stack and O(2^n * n) for the result list, since each subset can have up to n elements and there are 2^n subsets.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result){
        if(idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // choose
        path.add(nums[idx]);
        helper(nums,idx+1,path,result);
        path.remove(path.size()-1);
         // no choose
        helper(nums,idx+1,path,result);
    }
}
// ------------------------------------------------------------------------------Approach 2
// Start with an initial result list containing only the empty subset.
// For each element in the input array, iterate over all existing subsets and create new ones by appending the current element.
// Add these new subsets to the result, using deep copy to avoid modifying the original subsets.

// Time Complexity (TC):
// O(2^n * n) — There are 2^n subsets generated for an array of size n, and each subset takes up to O(n) time to create (due to deep copy via new ArrayList<>(...) and add(...)).

// Space Complexity (SC):
// O(2^n * n) — Because you're storing 2^n subsets and each subset can be up to n elements long.
// using iteration deep copy

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i =0 ;i<nums.length;++i){
            int size = result.size();
            for(int j =0 ;j<size;++j){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }
}
