import java.util.List;
import java.util.ArrayList;

public class SubsetsIteration {

        // ITERATION

        List<List<Integer>> powerSet;

        public List<List<Integer>> subsets(int[] nums) {

            powerSet = new ArrayList<>();

            //[[]] adding null subset
            powerSet.add(new ArrayList<>());

            // outer loop iterating over nums
            for(int n : nums) {

                // to avoid memory limit exceed error
                int size = powerSet.size();

                // inner loop iterating over deep copy of elements in existing power set
                // size is constant and is not effected dynamic updation of power set inside inner loop
                for(int j = 0; j < size; j++) {

                    List<Integer> currSubset = new ArrayList<>(powerSet.get(j));

                    currSubset.add(n);

                    powerSet.add(currSubset);
                }
            }
            return powerSet;
        }

    public static void main(String[] args) {

        SubsetsIteration object = new SubsetsIteration();

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

/* Time Complexity = O(N*2^N)

to generate 2^n subsets and copy to power set

Space Complexity = O(N*2^N)

2^n subsets of size n to keep elements in each subset
*/

