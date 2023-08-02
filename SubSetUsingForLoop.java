package BackTracking;

import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class SubSetUsingForLoop {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i=0; i<nums.length;i++)
        {
            int size = result.size();
            for(int j=0; j<size; j++)
            {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
