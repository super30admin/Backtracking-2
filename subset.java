//Time - O(2^n)
// Space - O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(0,nums,new ArrayList<Integer>());
        return res;
    }

    public void helper(int idx, int[] nums, List<Integer> path){
    //base
    res.add(new ArrayList<>(path));

    for(int i=idx;i<nums.length;i++){
        path.add(nums[i]);
        helper(i+1, nums,path);
        path.remove(path.size()-1);
    }
    }
}

