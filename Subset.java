import java.util.ArrayList;
import java.util.List;

// for loop based recursion with backtracking
// Time Complexity : O(2^n)  n is the length of the input array
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Y 
// Any problem you faced while coding this :

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>>  result = new ArrayList<>();
        /*helper(nums,0,new ArrayList<>(), result);*/
        result.add(new ArrayList<>());
        for(int i = 0; i< nums.length; i++)
        {
            int size = result.size();
            for(int j=0; j<size ; j++)
            {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }

    // using recursion and backtracking
    public void helper(int[] nums, int i, List<Integer> path, List<List<Integer>> result)
    {
        if(i == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        // not choose
        helper(nums, i+1, path, result);

        path.add(nums[i]);

        //choose
        helper(nums, i+1, path, result);

        path.remove(path.size() -1);

    }
    public static void main(String[] args)
    {
        int [] nums = {1,2,3};
        Subset cs = new Subset();
        System.out.println(cs.subsets(nums).toString());
    }
}
