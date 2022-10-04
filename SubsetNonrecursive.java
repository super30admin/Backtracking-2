class Solution {
    //tc-2n
    //sc-2n
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
 
        result = new ArrayList<>();
        
        if(nums == null) return result;
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++)
        {
           
            int size = result.size();
            for(int j=0;j<size;j++)
            {
               List<Integer> temp = new ArrayList<>(result.get(j)); 
               temp.add(nums[i]);
               result.add(temp);
            }
        }
       
        return result;
    }
 
}