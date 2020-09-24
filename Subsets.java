//Time Complexity-O(2^n)
//Space Complexity-O(n)
class Solution {
    List<List<Integer>>output=new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
      List<Integer>path=new ArrayList();  
      backTrack(nums,0,path);
      return output;
    }
    void backTrack(int[]nums,int index,List<Integer>path)
    {
        output.add(new ArrayList(path));
        for(int i=index;i<nums.length;i++)
        {
            path.add(nums[i]);
            backTrack(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
    
}