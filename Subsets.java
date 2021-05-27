// Time Complexity :O(2^n), n= length of input array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Subsets {
    //list to store result
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        //initializing result
        result = new ArrayList<>();
        //if input is empty
        if(nums.length==0) return result;
        //call method to find subsets
        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums, int index, List<Integer> path){
        //base
        //if reach end of nums array
        if(index==nums.length){
            //add path to result
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //case 1: not select
        backtrack(nums, index+1, path);

        //case 2: selected
        //update path
        path.add(nums[index]);
        //recurse to next index
        backtrack(nums, index+1, path);
        //backtrack
        //undo path update
        path.remove(path.size()-1);
    }
}