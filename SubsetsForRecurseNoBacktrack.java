import java.util.List;
import java.util.ArrayList;

public class SubsetsForRecurseNoBacktrack {

        //FOR LOOP RECURSION - NO BACKTRACKING
        List<List<Integer>> powerSet;

        public List<List<Integer>> subsets(int[] nums) {

            powerSet = new ArrayList<>();

            forRecurse(nums, 0, new ArrayList<>());

            return powerSet;

        }

        private void forRecurse(int[] nums, int pivot, List<Integer> subSet) {

            // first add subset of forRecurse call to result
            powerSet.add(subSet);

            // for loop recursion without backtracking
            for(int i = pivot; i < nums.length; i++) {

                //action
                List<Integer> temp = new ArrayList<>(subSet);
                temp.add(nums[i]);

                //recurse
                forRecurse(nums, i+1, temp);
            }

        }

        public static void main(String[] args) {

            SubsetsForRecurseNoBacktrack object = new SubsetsForRecurseNoBacktrack();

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

/* Time Complexity = O(n*2^n)

No difference between backtracking and no backtracking in this for loop recursion as a new deep copy of subset is created at a step in each

Space Complexity = O(n*2^n) - new Arraylist at each step */

