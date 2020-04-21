//time complexity: O(N * 2 ^ N)
//space complexity: O(N * 2 ^ N) 

import java.util.*;

class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {        
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0)    return result;
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>>result, int index)
    {
        if (index > nums.length)
            return;
        
        result.add(new ArrayList<>(list));

        for(int i=index; i < nums.length; i++)
        {
            list.add(nums[i]);
            backtrack(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }
}