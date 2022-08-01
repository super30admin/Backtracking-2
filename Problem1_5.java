//Time Complexity: O(n*2^n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1_5 {

    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null|| nums.length == 0)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for(int i =0; i < nums.length; i++){
            int size = result.size();
            for(int j =0; j < size; j ++){
                
               List<Integer> list = new ArrayList<>(result.get(j));
               list.add(nums[i]);
               result.add(list);
            }
        }
        return result;
    }
}
