//****SUBSETS - 0 1 RECURSION TECHNIQUE****
//Time complexity: 2 res to n
//Space complexity:n;
//Leetcode runnable: Y;
//Any doubts:N;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, int i, List<Integer> path)
    {
        //Base case
        if(i==nums.length)
        {
            result.add(new ArrayList<>(path));
            retu
        }
        
        //Logic
        //No choose case
        helper(nums, i+1, path);
        //Choose case
            //Action
            path.add(nums[i]);
            //Recurse
            helper(nums,i+1, path);
            //Backtrack
            path.remove(path.size()-1);
        
    }
}

////****SUBSETS - FOR LOOP RECURSION TECHNIQUE****
//Time complexity:2 res to n
//space complexity:0(n)
//Leetcode runnable : Y;
//Any doubts:N;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }
    private void helper(int[] nums, int index, List<Integer> path)
    {
        //Base case
        
        
        //Logic
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++)
        {
            //Action
            path.add(nums[i]);
            //Recurse;
            helper(nums, i+1, path);
            //BackTrack
            path.remove(path.size()-1);
        }
        
    }
}
