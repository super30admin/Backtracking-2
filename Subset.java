//Tc = 2*n
//sc = 2*n

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        Subset obj = new Subset();

        List<List<Integer>> obj1 = obj.subset(arr);
        System.out.println(obj1);

    }

    List<List<Integer>> result;

    public List<List<Integer>> subset(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;

    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        // base

        // logit
        result.add(new ArrayList<>(path));
        // action
        for (int i = pivot; i < nums.length; i++) {

            List<Integer> li = new ArrayList<>(path);
            li.add(nums[i]);
            // recurse
            helper(nums, i + 1, li);
            // backtrack
           // path.remove(path.size() - 1);
        }

    }
}