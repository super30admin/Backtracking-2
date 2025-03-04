//TC:- O(2 ^ n)
//SC:- O(n)

class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        //we will perform for loop based recursion
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtrack(nums, 0, path);
        return result;
    }

    public void backtrack(int[] nums, int pivot, List<Integer> path) {
        
        //logic
        result.add(new ArrayList<>(path));

        for(int i = pivot; i < nums.length; i++) {

            //action
            path.add(nums[i]);
            //recurse
            backtrack(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}

