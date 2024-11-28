// Time Complexity : O(2^n) since the number of subsets generated are 2^n
// Space complexity: O(n) recursive stack space
import java.util.ArrayList;
import java.util.List;

public class SubSets {
    List<List<Integer>> result;
    public List<List<Integer>> subset(int[] nums){
        this.result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>());
        return result;
    }

    private void generateSubsets(int [] nums, int i, List<Integer> path){
        // base case
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        //1.no choose case
        generateSubsets(nums, i+1, path);


        // 2. choose case
        path.add(nums[i]); // add the current element to the current path
        generateSubsets(nums,i+1, path); // recursively traverse when taking a number
        path.remove(path.size() - 1);// backtrack
    }

    public static void main(String [] args){
        SubSets solution = new SubSets();
        int [] nums = {1,2,3};
        System.out.println(solution.subset(nums));
    }
}
