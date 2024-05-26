import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++)
        {
            int size = result.size();
            for(int j=0; j<size; j++)
            {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }

        return result;
    }
}