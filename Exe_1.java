class Solution {
    private List<List<Integer>> ss;
    private List<Integer> s;
    public List<List<Integer>> subsets(int[] nums) {
        ss = new ArrayList<>();
        s = new ArrayList<>();
        subsets(nums, 0);
        return ss;
    }
    private void subsets(int[] nums, int index){
        ss.add(new ArrayList<>(s));
        for(int i =index; i<nums.length; ++i){
            s.add(nums[i]);
            subsets(nums, i+1);
            s.remove(s.size()-1);
        }
    }
}
//tc=2^n+n;
//sc=O(n);
