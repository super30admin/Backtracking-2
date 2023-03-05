import java.util.*;
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums,int index,List<Integer> path){
        //base
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //choose
        //action
        path.add(nums[index]);
        //recurse
        helper(nums,index+1,path);
        //backtrack
        path.remove(path.size()-1);
        //not choose
        helper(nums,index+1,path);
    }
}
