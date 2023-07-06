import java.util.List;
import java.util.ArrayList;

public class Subsets01RecurseBacktrack {

        //01 RECURSION  WITH BACKTRACKING

        List<List<Integer>> powerSet;

        public List<List<Integer>> subsets(int[] nums) {

            powerSet = new ArrayList<>();

            if(nums == null || nums.length == 0) return powerSet;

            recurse01Backtrack(nums, 0, new ArrayList<>());

            return powerSet;

        }

        private void recurse01Backtrack(int[] nums, int idx, List<Integer> subSet) {

            //base
            if(idx == nums.length) {

                //create a new deep copy while adding to result, because at the end of backtracking all subset paths become empty and that is not what we want to output
                powerSet.add(new ArrayList<>(subSet));
                return;
            }

            //logic

            //No choose
            recurse01Backtrack(nums, idx+1, subSet);

        /*choose - no choose order does't matter in backtracking approach
        as even if choose is written first, backtracking will clear the path from added element before the original path is called in no choose step*/

            //choose
            //action
            subSet.add(nums[idx]);

            //recurse
            recurse01Backtrack(nums, idx+1, subSet);

            //backtrack
            subSet.remove(subSet.size() - 1);

        }

       public static void main(String[] args) {

           Subsets01RecurseBacktrack object = new Subsets01RecurseBacktrack();

            int[] arr = {1,2,3};

            List<List<Integer>> result = object.subsets(arr);

            for (List<Integer> list : result) {
               for (Integer number : list) {
                System.out.print(number + " ");
               }
               System.out.println();
            }

        }
}

/*
TIME COMPLEXITY = O(N*2^N)

Two choices at each element - choose or no choose
n - elements in nums array
2^n - subsets

SPACE COMPLEXITY = O(N) - recursive stack - maximum size of subset is where all elements are included in it
*/

