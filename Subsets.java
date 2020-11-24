//Time complexity:O(2^n)
// SPace complexity:O(n)

class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if(nums==null|| nums.length==0) return result;
        
        helper(nums,new ArrayList<>(),0);
        return result;
        
    }
    private void helper(int[] nums ,List<Integer> path,int index)
    {
        //base
       
            result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++)
        {
           // List<Integer> path2=new ArrayList<>(path);
            path.add(nums[i]);
            helper(nums,path,i+1);
            path.remove(path.size()-1);
      
        }
        // helper(nums,new ArrayList<>(path),index+1);
        // path.add(nums[index]);
        // //1
        // helper(nums,new ArrayList<>(path),index+1);
    }
}
