//Time Complexity: O(2ⁿ) – Each element has two choices (include or exclude), leading to 2ⁿ subsets for n elements.
//Space Complexity: O(n) – Maximum depth of the recursion stack and temporary path list is n.

//Use backtracking to explore subsets by including or excluding each number.
//When the index reaches the end, add the current path to the result list.
//Recurse forward by choosing or skipping the current number at each step.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path)
    {
        if(index >= nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        recurse(nums, index+1, path);
        path.remove(path.size() - 1);
        recurse(nums, index+1, path);
    }
}