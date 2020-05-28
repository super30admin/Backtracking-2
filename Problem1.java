//time exponential o(2 pow n) * n
//space o(n) n is the input size
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length ==0)
            return res;
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> list, int index) {
        //base case
        res.add(new ArrayList<>(list));
        //logic
        for(int i=index;i<nums.length;i++) {
            //action
            list.add(nums[i]);
            //recurse
            backtrack(nums,list,i+1);
            //backtrack
            list.remove(list.size()-1);
        }
    }
}