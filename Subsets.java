// Time Complexity : O(exp)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
For loop based recursion and backtracking.
*/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        if(nums.length==0 || nums==null) return result;
        boolean[] visited= new boolean[nums.length];
        helper(nums, result, new ArrayList<>(),0,visited);
        return result;
    }

    private void helper(int[] nums,List<List<Integer>> result, ArrayList<Integer> values, int start, boolean[] visited){
        result.add(new ArrayList<>(values));
        for(int i=start;i<nums.length;i++){
            if(visited[i]) continue;
            values.add(nums[i]);
            visited[i]=true;
            helper(nums,result, values, i+1,visited);
            values.remove(values.size()-1);
            visited[i]=false;
        }
    }
}
