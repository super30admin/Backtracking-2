// Time Complexity: O(2^n)
// Space Complexity: O(n)
// where n is the number of elements in the input array

import java.util.*;

public class LC78 {
    List<List<Integer>> ans = new ArrayList<>();
    private void recurse(int nums[], int i, List<Integer> list){
        // Base Case
        if(i<0) {
            ans.add(new ArrayList(list));
            return;
        }
        // Logic
        recurse(nums, i-1, list);
        list.add(nums[i]);
        recurse(nums, i-1, list);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return ans;
        recurse(nums, nums.length-1, new ArrayList<>());
        return ans;
    }
}