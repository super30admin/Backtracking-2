import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsetsRecursion(int[] nums) { //O(2^(n)) T.C, O(h) S.C recursive stack
        result = new ArrayList<>();
        path = new ArrayList<>();

        recursion(nums, 0);
        return result;
    }

    void recursion(int[] nums, int pivot) {
        result.add(new ArrayList<>(path)); //in for loop recursion, each node is a valid subset

        for(int i=pivot; i<nums.length; i++) {
            //action
            path.add(nums[i]);

            //recurse
            recursion(nums, i+1);

            //backtrack
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsNonRecursion(int[] nums) { //O(2^(n) * k) T.C
        //where k is cost of creating deep copies and n is length of nums

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); //add an empty list initially to the result
        //as every input will have an empty list as a valid subset

        for(int num : nums) { //iterate over the input values
            int size = result.size(); //calculate the size of result at each level.
            //For ex, initially the size will be 1 -> empty list

            for(int j=0; j<size; j++) { //now iterate over the size of this result list
                List<Integer> temp = new ArrayList<>(result.get(j)); //create a deep copy of each subset already in res
                temp.add(num); //add the iterated num value to each deep-copied list
                result.add(temp); //add this deep copy as a new subset to the result
            }
        }

        /*
        What happens in the above logic is,
        1. Add an empty list as the first subset in result initially.
        2. Iterate over the values in input array, then iterate over the size of result until this level.
        3. Create a deep-copy of each list that is already in the result and add the current value to it.
        4. So initially, for an empty list add the first number and append this new list into result.
        Now the result contains [] and [1]. Then in the nested loop, repetition happens and by next level,
        the result will contain [], [1], [2], [1,2] and so on until all values are done.
         */
        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();

        int[] nums = {1,2,3};

        System.out.println("All valid subsets of given integer array " + Arrays.toString(nums)
                + " using recursion is \n" + subsets.subsetsRecursion(nums));

        System.out.println("All valid subsets of given integer array " + Arrays.toString(nums)
                + " using for loop over result and creating deep copies at each level is \n"
                + subsets.subsetsNonRecursion(nums));
    }
}