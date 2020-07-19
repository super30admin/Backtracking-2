//Time Complexity: O(n * 2^n)
//Space Complexity: O(n)
class Solution {
    
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subset(nums,0,new ArrayList<>(),list);
        return list;
    }
    
    private void subset(int[] nums,int start,List<Integer> ilist,List<List<Integer>> list) {
       
            list.add(new ArrayList<>(ilist));
            for (int i = start;i < nums.length;i++) {
            ilist.add(nums[i]);
            subset(nums,i+1,ilist,list);
            ilist.remove(ilist.size() - 1);
            }
        
    }
}
