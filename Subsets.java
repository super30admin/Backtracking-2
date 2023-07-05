import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        // //base
        // if(pivot> nums.length){
        // return;
        // }

        // logic
        // result.add(new ArrayList<>(path));
        result.add(path);
        for (int i = pivot; i < nums.length; i++) {
            List<Integer> li = new ArrayList<>(path);
            li.add(nums[i]);
            // path.add(nums[i]);
            helper(nums, i + 1, li);
            // path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();

        int[] nums = { 1, 2, 3 };

        // Call the subsets method and print the result
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println("Subsets: " + result);
    }
}