//Time Complexity: O(n * 2^n)
import java.util.ArrayList;
import java.util.List;

class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int index, ArrayList<Integer> temp){
        //Base Case
        if(index > nums.length) return;
        //Logic
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}