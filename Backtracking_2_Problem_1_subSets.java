//Time Complexity : O(n * 2^n)
//Space Complexity : O(n * 2^n)
//Runs successfully on leetcode
//No Problem

//Here we will be recursively calling the function the indexes of the given input
//After reaching on solution, we'll backtrack and try for the other possibility


import java.util.ArrayList;
import java.util.List;

public class Backtracking_2_Problem_1_subSets {


    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return list;

    }
    public void helper(int[] nums,int index,ArrayList<Integer> arr)
    {
        list.add(new ArrayList<>(arr));
        for(int i = index ; i < nums.length ; i++)
        {
            arr.add(nums[i]);
            helper(nums,i+1,arr);
            arr.remove(arr.size() - 1);
        }
    }


}
