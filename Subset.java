import java.util.ArrayList;
import java.util.List;

public class Subset {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {

      List<Integer> path = new ArrayList<Integer>();
      helper(nums, 0, path);
      return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path){
      //if(pivot >  nums.length) return;
      result.add(new ArrayList<Integer>(path));

      for(int i= pivot; i < nums.length; i++){

        path.add(nums[i]);
        helper(nums,  i+1, path);
        path.remove(path.size()-1);
      }
    }
  }
