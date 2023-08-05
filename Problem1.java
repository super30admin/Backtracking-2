// Time Complexity :O(nx2^n)
// Space Complexity : O(nx2^n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// this can be solved in bracktracing of chose not choose and for loop iteration


//Choose not choose backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums,int i,List<Integer> path){
        //base
        if(i==nums.length){
            result.add(path);
            return;
        }
        //logic
        //not choose
        helper(nums,i+1,new ArrayList<>(path));
        //choose
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path));
    }
}

//For loop recurssion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>(){});
        return result;
    }

    public void helper(int[] nums,int pivot,List<Integer>paths){
        //logic
            result.add(paths);
        //base
        for(int i=pivot;i<nums.length;i++){
            List<Integer> li = new ArrayList<>(paths);
            li.add(nums[i]);
            helper(nums, i+1, li);
        }
    }
}