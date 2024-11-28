// Time Complexity : O(n. 2^n) since the number of subsets generated are 2^n and there are n deep copies created
// Space complexity: O(n) recursive stack space
import java.util.ArrayList;
import java.util.List;

public class SubSetsBruteForce {
    List<List<Integer>> result;
    public List<List<Integer>> subsetBruteForce(int [] nums){
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;

    }

    private void helper(int[] nums, int i, List<Integer> path){

        // base case

        if( i == nums.length){ // we are adding the path at each and every subset
            result.add( new ArrayList<>(path));

        }

        // no choose case
        helper(nums, i+1, new ArrayList<>(path));

        // choose case
        path.add(nums[i]);
        helper(nums, i+1, new ArrayList<>(path));




    }
    public static void main(String [] args){
        SubSets solution = new SubSets();
        int [] nums = {1,2,3};
        System.out.println(solution.subset(nums));
    }
}
