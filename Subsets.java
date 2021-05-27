import java.util.*;

public class Subsets {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums == null || nums.length == 0) return result;
        helperRecursive(nums, new ArrayList(), 0);
        return result;
    }
    
    private void helperRecursive(int[] nums, List<Integer> path, int index) {
        //Base

        if(nums.length == index) {
            result.add(new ArrayList(path));
            return;
        }
        
        helperRecursive(nums, path, index+1);
        path.add(nums[index]);
        helperRecursive(nums, path, index+1);
        path.remove(path.size()-1);
    }

    private void helper(int[] nums, List<Integer> path, int index) {
        //Base
        result.add(new ArrayList(path));
        //Logic
        for(int i=index; i<nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(new int[]{1,2,3});
        System.out.println(result);
    }
}