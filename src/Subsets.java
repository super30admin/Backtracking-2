// TC: O(n * 2^n)
// SC: O(n * 2^n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums,new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums,List<Integer> path,int pivot) {
        result.add(new ArrayList<>(path));
        if(pivot == nums.length) return;
        for(int i=pivot;i<nums.length;i++) {
            path.add(nums[i]);
            helper(nums,path,i+1);
            path.remove(path.size()-1);
        }
    }
}