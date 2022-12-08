
import java.util.*;
//TC is O(n^2)
//SC is O(number of subsets in result)

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> copyList = new ArrayList<>(result.get(j));
                copyList.add(nums[i]);
                result.add(copyList);

            }
        }

        return result;

    }
}