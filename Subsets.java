
// O(N 2^N) time to generate all subsets and copy to output list
// O(N) space to maintain curr

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n, k;
    List<List<Integer>> output = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for ( k = 0; k < n + 1; k++){
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
    
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums){
        // if combination is done
        if (curr.size() == k){
            output.add(new ArrayList(curr));
            return;
        }
        
        for (int i = first; i < n; ++i){
            curr.add(nums[i]); // add i into the current combination
            backtrack(i + 1, curr, nums); // use next integers to complete the combination
            curr.remove(curr.size() - 1); // backtrack
        }
        

    }
}