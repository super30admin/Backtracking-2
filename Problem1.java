class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int sz = res.size();
            for(int j = 0; j < sz; j++){
                List<Integer> li = new ArrayList<>(res.get(j));
                li.add(nums[i]);
                res.add(li);
            }
        }
        return res;
    }
}
