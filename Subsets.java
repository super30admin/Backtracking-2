import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //Time Complexity: O(N*2^N)
    // Space Complexity: O(N)
    List<Integer> current;
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        current = new ArrayList<>();
        list = new ArrayList<>();
        backtrack(nums, 0);

        return list;
    }

    private void backtrack(int[] nums, int idx){
        list.add(new ArrayList<>(current));

        for(int i = idx; i < nums.length; i++){

            current.add(nums[i]);
            backtrack(nums, i+1);
            current.remove(current.size() - 1);

        }
    }
}
