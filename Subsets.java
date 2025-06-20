// Time complexity- O(n * 2^n) where n is the length of array
// Space complexity- O(n * 2^n)
import java.util.*;
public class Subsets {
    static List<List<Integer>>  result = new ArrayList<>();
    static List<List<Integer>> subsets(int[] nums) {
        makeSubset(nums, 0, new ArrayList<>());
        return result;
    }
    static void makeSubset(int[] nums,int pivot, List<Integer> li) {
        result.add(new ArrayList<>(li));
        for(int i = pivot; i < nums.length; i++) {
            li.add(nums[i]);
            makeSubset(nums, i+1, li);
            li.remove(li.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
