//TC : O(2^3) SC : O(N)
class Solution {
    List <List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();

        helper(nums,0,path);
        return result;
    }

    private void helper(int[] nums,int index,List<Integer> path){
        //base 

        //logic
        result.add(new ArrayList(path));
        for(int i=index;i<nums.length;i++)
        {
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}