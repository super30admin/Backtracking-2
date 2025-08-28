// This solution uses recursion based structure to iterate through the elements and generate all combinations and at the end capture the combination. Basic principle to either do not choose and move to next element or choose and move to next element while backtracking it.
class Solution {
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        fetchSubsets(nums, 0, new ArrayList());
        return list;
    }

    private void fetchSubsets(int[] nums, int index, List<Integer> path) {
        if(index==nums.length) {
            list.add(new ArrayList(path));
            return;
        }

        fetchSubsets(nums, index+1, path);
        path.add(nums[index]);
        fetchSubsets(nums, index+1, path);
        path.remove(path.size()-1);
    }
}
