
// Subsets

// backtracking with time complexity of O(2^n)
Space Complexity: Stack space of O(n)

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        helper(nums, 0, new ArrayList<>());
        return result;
        
    }

    private void helper(int[] nums, int i  , List<Integer> path){

        if(i == nums.length ){
            result.add(new ArrayList<>(path));
            return;
        }

        //not choose
        helper(nums, i+1 , path);

        path.add(nums[i]);

        //choose

        helper(nums, i+1, path);
        path.remove(path.size()-1);
    }
}
