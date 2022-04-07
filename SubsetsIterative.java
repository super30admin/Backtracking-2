/**
 * time complexity is exponential - O(2^N)
 * space complexity is exponential - O(2^N)
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) {
            return null;
        }
        result.add(new ArrayList<>());
        
        for(int n : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(n);
                result.add(set);
            }
        }
        
        return result;
        
    }
}