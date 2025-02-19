// Time Complexity : O (2^n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int i, j;
        List<List<Integer>> result = new ArrayList<>();
        int numSets = 1 << n;
        //from 0 to 2^n - 1
        for(i = 0; i < numSets; i++) {
            List<Integer> curr = new ArrayList<>();
            for(j = 0; j < n; j++) {
                //if a bit is set, add the corresponding number to the subset
                //(i & (1 << j)) checks if the jth bit is set in i
                if((i & (1 << j)) != 0) curr.add(nums[j]);
            }
            result.add(curr);
        }
        return result;
    }
}
