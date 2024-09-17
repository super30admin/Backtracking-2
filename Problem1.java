
// Time complexity : O(m2^n)
//Space complexity : O(n)

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        generatesubsets(nums,0);
        return result;
    }
    
    public void generatesubsets(int[] nums, int index){
        if(index>nums.length-1){
            return;
        }
        int size = result.size();
        for(int i=0;i<size;i++){
            List<Integer> sub = new ArrayList<>(result.get(i));
            sub.add(nums[index]);
            result.add(sub);
        }
        generatesubsets(nums,index+1);
    }
}