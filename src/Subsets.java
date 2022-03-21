// Time Complexity:           O(n * 2^n)
// Space Complexity:          O(n)
// where n is length of given String
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        SolutionSubsets obj = new SolutionSubsets();
        int[] nums = {1,2,3};
        List<List<Integer>> list = obj.subsets(nums);
        System.out.println(list);
    }
}

class SolutionSubsets {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>());
        return result;
    }

    private void subsets(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // ACTION
        list.add(nums[index]);
        // RECURSION
        subsets(nums, index+1, list);
        // BACKTRACKING
        list.remove(list.size()-1);

        // not choose
        subsets(nums, index+1, list);
    }
}



//// ****************************** Another Approach ******************************
//class SolutionSubsets {
//
//    List<List<Integer>> result;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        result = new ArrayList<>();
//        subsets(nums, 0, new ArrayList<>());
//        return result;
//    }
//
//    private void subsets(int[] nums, int index, List<Integer> list) {
//
//        result.add(new ArrayList<>(list));
//
////         // we can add not choose case externally as well instead of the above line
////         if(index == nums.length) {
////             result.add(new ArrayList<>(list));
////             return;
////         }
////         subsets(nums, nums.length, list);
//
//        for(int i=index; i<nums.length; i++) {
//            // ACTION
//            list.add(nums[i]);
//            // RECURSION
//            subsets(nums, i+1, list);
//            // BACKTRACKING and NOT CHOOSE
//            list.remove(list.size()-1);
//        }
//    }
//}