import java.util.ArrayList;
import java.util.List;

public class Subsets {
        List<List<Integer>> res;

        public List<List<Integer>> subsets(int[] nums) {
            this.res = new ArrayList<>();
            helper(nums, 0, new ArrayList<>());
            return res;
        }

        private void helper(int[] nums, int i, List<Integer> path) {
            //base
            if (i == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            //action
            path.add(nums[i]);

            //recurse
            helper(nums, i + 1, path);

            //backtrack
            path.removeLast();

            //no choose
            helper(nums, i + 1, path);

        }
    }

//TC: O(n*2^n) - subsets created 2^n and copying of elements to new list for every subset created = n
// SC: O(n) - recursive stack


//Approach - 2
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }

        return res;
    }
}

// TC: O(2^n)
// SC: O(n)