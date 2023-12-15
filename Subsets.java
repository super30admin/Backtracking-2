import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets3(int[] nums) {
        // TC:O(n*(2^n))
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int size = result.size();
            for(int j = 0; j < size; j++){
                List<Integer> li = new ArrayList<>(result.get(j)); //create deep copy
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }
    //Backtracking with 0-1 recursion
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        // TC:O(2^m)
        // SC: O(h)
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, int i){
        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //dont choose
        helper(nums, path, i+1);
        //choose
        //action
        path.add(nums[i]);
        //recurse
        helper(nums, path, i+1);
        //backtrack
        path.remove(path.size()-1);
    }
//**For Based Recursion************
    List<List<Integer>> result2;
    public List<List<Integer>> subsets2(int[] nums) {
        // TC:O(2^m)
        // SC: O(h)
        result2 = new ArrayList<>();
        helper2(nums, 0, new ArrayList<>());
        return result2;
    }
    private void helper2(int[] nums, int pivot, List<Integer> path2){
        //base
        result2.add(new ArrayList<>(path2));
        if(pivot == nums.length) return;

        //logic
        for(int i = pivot; i < nums.length; i++ ){
            path2.add(nums[i]);
            helper2(nums, i+1, path2);
            path2.remove(path2.size()-1);
        }
    }
}
