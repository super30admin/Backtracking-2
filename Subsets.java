import java.util.*;

public class Subsets{


    public static List<List<Integer>> result;
    public static List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
        {
            return result;
        }
        
        helper(nums,0,new ArrayList<>());
        
        return result;
    }
    
    private static void helper(int[] nums, int index, List<Integer> path)
    {
        
        if(index == nums.length)
        {
            result.add(path);
            return;
        }
        
        //not choose case
        helper(nums,index+1,new ArrayList<>(path));
        
        //choose case 
        path.add(nums[index]);
        helper(nums,index+1,new ArrayList<>(path));
    }


    public static void main(String args[])
    {
        int nums[] = {1,2,3};

        List<List<Integer>> ans = subsets(nums);
        
        for(List<Integer> temp : ans)
        {
            System.out.println(temp);
        }
    }
}