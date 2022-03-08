import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(n*2^n),here n is the number of elements in the nums array, every number is gonna have 2^n combinations for
every number
Space Complexity: O(n) n is the size of recursion tree
Run on leetcode: Yes

Approach:
1. In my backtracking algorithm, I am gonna make all possible combinations with each number, as answer also includes empty
list, I am gonna start by adding an empty list into the result.
2. when start index is 0, my result would look like [[],[1],[1,2],[1,2,3],(when I remove the last number from the list)[1,3]]
the backtracking recursion would follow the same strategy both for 2 and 3
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();;
        List<Integer> list = new ArrayList<>();

        if(nums == null){
            return result;
        }
        backtrackingMethod(nums, 0, list, result);
        return result;
    }

    public static void backtrackingMethod(int[] nums, int start, List<Integer> list, List<List<Integer>> result){

        result.add(new ArrayList<>(list));
        for(int i = start; i<nums.length; i++){
            list.add(nums[i]);
            backtrackingMethod(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};

        System.out.println("Subsets: "+ subsets(nums));
    }
}
