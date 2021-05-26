import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
       
        for(int i=0; i<nums.length; i++){
            int t=result.size();
           for(int j=0; j<t; j++){
               
               List<Integer> temp= new ArrayList<>(result.get(j));
               temp.add(nums[i]);
               result.add(new ArrayList<>(temp));
               
           }
        }
       
        return result;
    }
    
}
