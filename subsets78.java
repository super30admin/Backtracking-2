// Time Complexity : On*(2^m)
// Space Complexity : O(2^m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
            int size = res.size();
            for(int j = 0; j<size;j++){
                List<Integer> current = new ArrayList<>(res.get(j));
                current.add(nums[i]);
                res.add(current);
            }
        }
        return res;
    }

}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, new ArrayList<>(), res, nums);
        return res;
    }

    public void helper(int ind, List<Integer> state, List<List<Integer>> res, int[] nums){
        List<Integer> temp = new ArrayList<>();
        for(int t: state){
            temp.add(t);
        }
        res.add(temp);

        for(int i = ind;i<nums.length;i++){
            state.add(nums[i]);
            helper(i+1, state, res, nums);
            state.remove(state.size()-1);
        }
    }
}
