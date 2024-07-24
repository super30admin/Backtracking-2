/*
TC --> O(2^n)
Sc --> O(1)
 */
class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        Helper(0, nums, new ArrayList<>());
        return res;

    }

    public void Helper(int idx, int[] nums, List<Integer> path) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }//if
        path.add(nums[idx]);
        Helper(idx + 1, nums, path);
        path.remove(path.size() - 1);
        Helper(idx + 1, nums, path);

    }
}
