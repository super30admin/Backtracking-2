// Time Complexity : 2^N - two choices for n elements
// Space Complexity : 2^N * N - in worst case, all elements can be present in subsets & we have 2^n subsets total
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Subsets {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return list;
    }

    private void backtrack(int [] nums, List<Integer> tempList, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}