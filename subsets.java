
time complexity: O(n)
space complexity: O(1)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, 0, cur);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int start, List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        for(int i=start; i< nums.length; i++){
            cur.add(nums[i]);

            dfs(nums, res, i+1, cur); 
            cur.remove(cur.size()-1);
    }
}
    }