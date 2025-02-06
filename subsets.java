import java.util.ArrayList;
import java.util.List;

public class subsets {
}
//o/1 recursion using backtracking
class Solution {
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
        // dont pick
        recurse(nums, index + 1, path);
        // pick
        path.add(nums[index]);
        recurse(nums, index + 1, path);
        path.remove(path.size()-1);
    }
}

//for loop based recursion without back BT
class looWithoutpBT {
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
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            List<Integer> lst = new ArrayList<>(path);
            lst.add(nums[i]);
            recurse(nums, i + 1, lst);
        }
        return;
    }

}
//for loop based recrusion using BT
class loopBT {
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
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            recurse(nums, i + 1, path);
            //backtrack
            path.remove(path.size()-1);
        }
        return;
    }

}