// Time Complexity : O(2^n) since the number of subsets generated are 2^n
// Space complexity: O(n) recursive stack space
import java.util.ArrayList;
import java.util.List;

public class SubsetsWithForLoopRecurssion {
    static List<List<Integer>> result;
    public static List<List<Integer>> subSetWithForLoop(int[] nums){
        result = new ArrayList<>();
    generateSubsetsWithForLoopRecurssion(nums, 0, new ArrayList<>());
    return result;

    }

    private static void generateSubsetsWithForLoopRecurssion(int[] nums, int pivot, List<Integer> path) {

        result.add(new ArrayList<>(path)); // add the current subset to the result list

        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]); // Include nums[i]
            generateSubsetsWithForLoopRecurssion(nums, i + 1, path); // recursive call
            path.remove(path.size() - 1); // backtrack

        }
    }
    public static void main(String [] args){;
        int [] nums = {1,2,3};

        //System.out.println(solution.subSetWithForLoop(nums));
        List<List<Integer>> subsets = subSetWithForLoop(nums);
        // Print all subsets
        for(List<Integer> subset: subsets){
            System.out.println(subset);
        }
    }
}
