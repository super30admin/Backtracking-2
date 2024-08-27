/**

 L.C: 78. Subsets

 Approach: Recursion with Backtracking


 Time Complexity: 2^N
 Space Compllexity: O(n) -> max entries in the stack id nums.length

 */


class Subsets {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;

    }

    private void backtrack(int[] nums, int index, List<Integer> path) {

        //base

        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }


        //recurse
        //case 0
        backtrack(nums, index+1, path);

        //action
        path.add(nums[index]);

        //case 1
        backtrack(nums, index+1, path);

        path.remove(path.size()-1);

    }
}