import java.util.List;
import java.util.ArrayList;

public class Subsets01RecurseNoBacktrack {

        //01 RECURSION - NO BACKTRACKING

        List<List<Integer>> powerSet;

        public List<List<Integer>> subsets(int[] nums) {

            this.powerSet = new ArrayList<>();

            recurse01(nums, 0, new ArrayList<>());

            return powerSet;

        }

        private void recurse01(int[] nums, int idx, List<Integer> subSet) {

            //base
            if(idx == nums.length) {

                powerSet.add(subSet);
                return;
            }

            //logic

            //choose
            List<Integer> temp = new ArrayList<>(subSet);
            temp.add(nums[idx]);

            recurse01(nums, idx+1, temp);

            //No choose
            recurse01(nums, idx+1, new ArrayList<>(subSet));
        }

        public static void main(String[] args) {

             Subsets01RecurseNoBacktrack object = new Subsets01RecurseNoBacktrack();

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

SPACE COMPLEXITY = O(N*2^N)

create n size new list of integers 2^n times
*/
