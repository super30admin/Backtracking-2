class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    public void helper(int[] nums, int i, List<Integer> path){
        if(i==nums.length){
            res.add(new ArrayList<>(path));
            return;
        } 
        helper(nums,i+1,path);
        path.add(nums[i]);
        helper(nums, i+1, path);
        path.remove(path.size()-1);
    }
}

//Time complexity : O(2^N)
//Space complexity : O(2^N)

