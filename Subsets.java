// Time Complexity : O(2*n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.*;
public class Subsets {

        List<List<Integer>> res;
        public List<List<Integer>> subsets(int[] nums) {


            res = new ArrayList<>();

            helper(nums,new ArrayList<>(),0);

            return res;
        }

        public void helper(int[] nums,List<Integer> lst, int index)
        {
            // base case 
            if(index == nums.length)
            {
                res.add(new ArrayList<>(lst));
                return;
            }

            // logic
            // do not choose,-> choose nothing case
            helper(nums,lst,index+1);

            // choose something case
            // action -> put something in the list
            lst.add(nums[index]);
            //recurse
            helper(nums,lst,index+1);
            // backtrack
            lst.remove(lst.size()-1);

        }


}