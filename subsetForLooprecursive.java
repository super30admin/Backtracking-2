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
        result.add(path); // this for empty set 
        for(int i = index; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>(path);
            list.add(nums[i]);
            helper(nums, i + 1, list);
        }
    }
}