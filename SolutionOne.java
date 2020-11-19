// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Problems while backtracking or during dry run on whiteboard

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        if(nums== null || nums.length==0)
            return result;

        result=new ArrayList<>();

        helper(nums,new ArrayList<>(),0);

        return result;
    }

    public void helper(int[] nums, List<Integer> temp, int index)
    {
        //base
        result.add(new ArrayList<>(temp));

        for(int i=index;i<nums.length;i++)
        {

            //action
            temp.add(nums[i]);

            //recurse
            helper(nums,temp,i+1);

            //backtrack

            temp.remove(temp.size()-1);

        }


    }
}
/*
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int num: nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> sublist = new ArrayList<Integer>(result.get(i));
                sublist.add(num);
                result.add(sublist);
            }
        }
        return result;
    }
* */