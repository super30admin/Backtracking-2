//Time Complexity:2^n where n is the subset added to the list
//Space complexity:O(List of Subset)
//Facebook Interview
//Using Recursion
//Given an array set [1,2,3] for this consider choose and not choose based on the index position value .Do not choose when I don't add anything to my path and choose when I add the current element added to the list path when I don't have any element that is the base case it return the empty arraylist as result.
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int index,List<Integer>path){
        //base
        if(index == nums.length){
            result.add(path);
            return;
        }
        //logic -zero case or do not choose case
        helper(nums,index+1,new ArrayList<>(path));
        //one case or choose case
        path.add(nums[index]);
        helper(nums,index+1,new ArrayList<>(path));
    }
}