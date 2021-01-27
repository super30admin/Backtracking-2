// Time Complexity : The time complexity is exponential since at every recursive call we are deciding whrther to choose or to not choose
// Space Complexity : The space complexity is O(n) where n is the length of the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    List<List<Integer>> output;

    public List<List<Integer>> subsets(int[] nums) {

        output = new LinkedList<>();

        if(nums == null || nums.length == 0){
            return output;
        }

        backTrack(nums,0,new LinkedList<>());

        return output;

    }

    public void backTrack(int[] nums,int index,List<Integer> subset){

        // add the subset to the list at every recursive call
        output.add(new LinkedList<>(subset));

        for(int i=index;i<nums.length;i++){

            // action
            subset.add(nums[i]);
            // recursion
            backTrack(nums,i+1,subset);
            //backtrack
            subset.remove(subset.size()-1);

        }
    }
}