//TC - O(N2)
//SC - O(N2)
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
        
        if(nums.length==0) return res;
        
        res.add(new ArrayList<>());
        
        for(int i=0;i<nums.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                List<Integer> arr = new ArrayList<>(res.get(j));
                arr.add(nums[i]);
                res.add(arr);
            }
        }

        
        return res;
        
        
        
        
    }
}