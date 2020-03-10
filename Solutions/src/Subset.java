// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No
class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(),result,0,nums);

        return result;
    }
    private void backtrack(List<Integer> tmp, List<List<Integer>> result,int index, int[] nums){
        result.add(new ArrayList<>(tmp));
        for(int i=index;i<nums.length;i++){
            tmp.add(nums[i]);
            backtrack(tmp,result,i+1, nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
