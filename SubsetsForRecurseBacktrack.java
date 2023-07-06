import java.util.List;
import java.util.ArrayList;

public class SubsetsForRecurseBacktrack {

        //FOR LOOP RECURSION WITH BACKTRACKING

        List<List<Integer>> powerSet;

        public List<List<Integer>> subsets(int[] nums) {

            powerSet = new ArrayList<>();

            forRecurseBacktrack(nums, 0, new ArrayList<>());

            return powerSet;

        }
        private void forRecurseBacktrack(int[] nums, int pivot, List<Integer> subSet) {

            // first add subset of forRecurseBacktrack call to result
            powerSet.add(new ArrayList<>(subSet));

            // for loop recursion with backtracking
            for(int i = pivot; i < nums.length; i++) {

                //action
                subSet.add(nums[i]);

                //recurse
                forRecurseBacktrack(nums, i+1, subSet);

                //backtrack
                subSet.remove(subSet.size() - 1);
            }

        }

    public static void main(String[] args) {

        SubsetsForRecurseBacktrack object = new SubsetsForRecurseBacktrack();

        int[] arr = {1,2,3,4};

        List<List<Integer>> result = object.subsets(arr);

        for (List<Integer> list : result) {
            for (Integer number : list) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }

}

/* Time Complexity = O(n*2^n)

2^n - subsets
n - elements

No difference between backtracking and no backtracking in this for loop recursion as a new deep copy of subset is created at a step in each

Space Complexity = O(n) - recursive stack */

