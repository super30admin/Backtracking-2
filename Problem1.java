import java.util.ArrayList;
import java.util.List;
/*
Recurse based 0/1 
*/
class Solution1 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;

    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(path);
            return;
        }
        // logic
        recurse(nums, index + 1, new ArrayList<>(path));
        path.add(nums[index]);
        recurse(nums, index + 1, new ArrayList<>(path));
        

    }
}


/*
Backtrack based 0/1 approach
*/

class Solution2 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;

    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        recurse(nums, index + 1, path);
        path.add(nums[index]);
        recurse(nums, index + 1, path);
        path.remove(path.size() - 1);

    }
}

/*
For Loop based recursion
*/

class Solution3 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;

    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // base

        // logic
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            recurse(nums, i + 1, newList);
        }

    }
}

/*
For Loop based BackTrack
*/

class Solution4 {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;

    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // base

        // logic
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            recurse(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }
}