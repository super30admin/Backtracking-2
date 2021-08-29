
// Time Complexity : O(2*n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach
1) in this question we can use both the techniques, a for loop and a normal without for loop approach.
2) we go with without a for loop approach and we use recursion having 2 choices
-> choose and dont choose
3) initially when we decide not to choose, we just increment the index
4) then we we need to choose, first we add element to the list and then give a recursion call to the method. 
5) once the recursion ends, we can remove the last element of the list.
6) Also, we only add elements to the res list when our index reaches to end of nums array.
Thus when we exhaust choices.
*/



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
