//78. Subsets - https://leetcode.com/problems/subsets/description/
//Time Complexity: O(n * (2^n))
//Space Complexity: O(n * (2^n)) + O(n) Stack Space

//Brute Force
//01 Approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path){
        //base case
        if(index == nums.length){
            result.add(path);
            return;
        }
        //logic
        //no choose
        helper(nums, index+1, new ArrayList<>(path));

        //choose
        path.add(nums[index]);
        helper(nums, index+1, new ArrayList<>(path));

    }
}

//Time Complexity: O(2^n)
//Space Complexity: O(2^n)
//Backtracking Solution with choose, no choose
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path){
        //base case
        if(index == nums.length){
            //create deep copies before adding as we don't want to backtrack the entire path
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //no choose
        //no new ArrayList will be created in backtracking
        helper(nums, index+1, path);

        //choose
        path.add(nums[index]);
        helper(nums, index+1, path);
        //backtrack
        path.remove(path.size()-1);

    }
}

//Time Complexity: O(2^n)
//Space Complexity: O(n)
//Backtracking - Optimal for loop Solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path){
        //adding subset at each level
        result.add(new ArrayList<>(path));

        //base condition
        if(pivot == nums.length)
            return;

        for(int i=pivot; i<nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}

//for loop without backtracking
//Time Complexity: O(2^n)
//Space Complexity: O(1)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        result.add(new ArrayList<>());

        //for loop over nums array
        for(int i=0; i<nums.length; i++){
            //for loop over result list
            int size=result.size();
            for(int j=0; j<size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}