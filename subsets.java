//time: O(n^2) where n is length of string;
//space: O(n^2) where n is length of string;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    // private void helper(int[] nums, int i , List<Integer>path){
    //     if(i == nums.length) {
    //         result.add(path);
    //         return;
    //     }

    //     //Dont choose

    //     helper(nums, i+1, new ArrayList<>(path));

    //     //choose
    //     path.add(nums[i]);
    //     helper(nums, i+1,  new ArrayList<>(path) );
    // }

    // private void helper(int[] nums, int index , List<Integer>path){
    //     result.add(path);
    //     for(int i = index; i<nums.length;i++){
    //         List<Integer> temp = new ArrayList<>(path);
    //         temp.add(nums[i]);
    //         //choose
    //         helper(nums, i+1,  temp);
    //     }
    // }

    private void helper(int[] nums, int index , List<Integer>path){
        result.add(new ArrayList<>(path));
        for(int i = index; i<nums.length;i++){
            path.add(nums[i]);
            //choose
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}