// Time complexity : O(2^n) because for each n - we have 2^n copies in result list
// space Complexity : O(1) is constant as there is no recursive stack space
import java.util.ArrayList;
import java.util.List;

public class SubSetWithnestedForLoop {
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // create an empty subset

        // iterate over each element in the nums array
        for(int i =0; i< nums.length; i++){
            int size = result.size();
            for(int j =0; j < size; j++){
               List<Integer> newSubset = new ArrayList<>(result.get(j)); //  Create new deep copies from result list
               newSubset.add(nums[i]); // add the current element into the subset list
               result.add(newSubset); // add the subset list to the resul list

            }
        }
return result;
    }
    public static void main(String[] args){
        SubSetWithnestedForLoop solution = new SubSetWithnestedForLoop();
        int [] nums = {1,2,3};
        System.out.println(solution.subsets2(nums));
    }
}
