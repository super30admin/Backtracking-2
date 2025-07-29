class Solution {
    List<List<Integer>> result;

    // for loop recursion
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path) {

        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; ++i) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }



    // 0 1 recursion
    public List<List<Integer>> subsets01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack01(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack01(int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // do not choose or 0 case
        backtrack01(nums, index + 1, path);

        path.add(nums[index]);

        // choose or 1 case
        backtrack01(nums, index + 1, path);
        path.remove(path.size() - 1);


        // bad but working way - since we create new list everytime, bad on space..
        // do not choose or 0 case
        // recurse(nums, index + 1, new ArrayList<>(path));
        // path.add(nums[index]);
        // // choose or 1 case
        // recurse(nums, index + 1, new ArrayList<>(path));
    }

}