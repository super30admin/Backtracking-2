// space: O(n)
// time: O(n * 2^n)
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums== null || nums.length==0) return result;
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums,int index, List<Integer> list)
    {
        if(index>nums.length) return;
        result.add(new ArrayList<>(list));
        
        for(int i=index;i<nums.length;i++)
        {
            list.add(nums[i]);
            // checking all children 
            backtrack(nums,i+1,list);
            // backtrack
            list.remove(list.size()-1);
        }
    }
}