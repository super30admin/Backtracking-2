//tc : exponentital --> 2 ^ n
// sc : recursive stack spaace ---> o(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path) {
        //base
        // if(index == nums.length) {
        //     result.add(new ArrayList<>(path));
        //     return;
        // }
       
        // the above base case isnt nevcessary cuz the below for loop wil ltake care of such siutation 
        result.add(new ArrayList<>(path)); 
        for(int i = index; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}