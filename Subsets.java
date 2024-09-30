import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // for loop based recurseive solution
    //time = o(n)2
    //spce(O n)
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        result = new ArrayList<>();

        recurse(nums, 0, new ArrayList<>());
        return result;

    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            List<Integer> mylist = new ArrayList<>(path);
            mylist.add(nums[i]);
            recurse(nums, i+1, mylist);

        }
    }
}
