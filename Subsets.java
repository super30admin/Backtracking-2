import java.util.ArrayList;
import java.util.List;

// TC: O(2 ^ n) exponential as it generate all possible unique subsets. where n is the length of input array
// SC: O(h) where h is the height of the recursive stack.  in the worst case, it can be O(n). 
// the code doesn't use auxilliary space.

// Following is the for loop based backtracking approach.
public class Subsets {
    static List<List<Integer>> output;

    public static void main(String[] args) {
        for (List<Integer> list : subsetsByCascading(new int[] { 1, 2 })) {
            System.out.println(list);
        }
        output = new ArrayList<>();
        subsetsByRecursion(new int[] { 1, 2, 3 }, 0, new ArrayList<>());
        for (List<Integer> i : output) {
            System.out.println(i);
        }
    }

    public static List<List<Integer>> subsetsByCascading(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> present : output) {
                List<Integer> temp = new ArrayList<>(present);
                temp.add(num);
                current.add(temp);
            }
            output.addAll(current);
        }
        return output;
    }

    private static void subsetsByRecursion(int[] nums, int start, List<Integer> current) {
        output.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                subsetsByRecursion(nums, i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
