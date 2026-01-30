import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        helper(nums, result, currSet, 0);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> currSet, int idx){
        //base
        if(idx == nums.length){
            result.add(new ArrayList<>(currSet));
            return;
        }
        //logic
        //choose
        currSet.add(nums[idx]);
        helper(nums, result, currSet, idx+1);
        currSet.remove(currSet.size()-1);

        //no choose
        helper(nums, result, currSet, idx+1);

    }
}
