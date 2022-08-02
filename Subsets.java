// time complexity exponentional

/*class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return result;
        }
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index,List<Integer> path)
    {
        if(index==nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        helper(nums,index+1,path);
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
    }
}*/

class Solution
{
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return result;
        }
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index,List<Integer> path)
    {
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++)
        {
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
/*
class Solution
{
List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return result;
        }
        helper(nums,0,new ArrayList<>());
        return result;
    }
private void helper(int[] nums, int index,List<Integer> path)
{
    result.add(new ArrayList<>(path));
    for(int i=index;i<nums.length;i++)
    {
        List<Integer> newlist = new ArrayList<>(path);
        newlist.add(nums[i]);
        helper(nums,i+1,newlist);
        //path.remove(path.size()-1);
    }
}
}*/