// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

//solution without recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int size = result.size();
            for( int j = 0; j < size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}

/*
//backtrack using pivot
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        //base
        //logic
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            //action
            //List<Integer> temp = new ArrayList<>(path);
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size() - 1);
        }        
    }
}
*/
/*
//rcursion using pivot
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        //base
        //logic
        result.add(path);
        for(int i = index; i < nums.length; i++){
            //action
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            //recurse
            helper(nums, i+1, temp);
        }        
    }
}
*/

/*
//backtrack of 0, 1 recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //no choose
        helper(nums, i + 1, path);
        //choose
        //action
        path.add(nums[i]);
        //recurse
        helper(nums, i + 1, path);
        //backtrack
        path.remove(path.size() - 1);

        
    }
}
*/

/*
//brute force 0 , 1 recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length){
            result.add(path);
            return;
        }
        //logic
        //no choose
        helper(nums, i + 1, new ArrayList<>(path));
        //choose
        path.add(nums[i]);
        helper(nums, i + 1, new ArrayList<>(path));

        
    }
}
*/