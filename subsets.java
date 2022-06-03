//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        rec(res, new ArrayList<>(), nums, 0, used);

        return res;
    }

    private void rec(List<List<Integer>> res, List<Integer> temp, int[] nums, int idx, boolean[] used){

        res.add(new ArrayList<>(temp));
        if(temp.size() == nums.length){
            return;
        }

        for(int i = idx; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            rec(res, temp, nums, i, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}