import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(2^N)
//Space Complexity : O(N)
class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int pivot, List<Integer> path){
        //add path list to result
        result.add(new ArrayList<>(path));
        //for loop recursion
        for(int i = pivot; i < nums.length; i++){
        //action
        path.add(nums[i]);
        //recurse
        helper(nums, i+1, path);
        //backtrack
        path.remove(path.size()-1);
        }
    }
}