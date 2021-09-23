class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        result.add(new ArrayList<>());
        for(int n : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> set = new ArrayList<Integer>(result.get(i));
                set.add(n);
                result.add(set);
            }
        }
        return result;
    }
}