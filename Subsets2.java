import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    // This is another implementation for the same problem
    // Instead of the recursive approach, it uses iterative approach
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        // Initiate with an empty list - []
        result.add(new ArrayList<>());


        // Get the previous lists in result list
        // append to each list append the next element in nums array
        /*
            [
                []
                [1]
                [2]
                [1,2]
                [3]
                [1,3]
                [2,3]
                [1,2,3]
            ]
         */
        for(int i=0; i < nums.length; i++) {
            int size = result.size();
            for(int j=0; j < size; j++) {
                List<Integer> tempList = new ArrayList<>(result.get(j));
                tempList.add(nums[i]);
                result.add(tempList);
            }
        }

        return result;
    }
}
