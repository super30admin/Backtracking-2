import java.util.ArrayList;
import java.util.List;

public class Subsets {

    //Using approach 01 recursion with backtracking
    // time complexity = O(2^m+n)
    //space complexity = O(h)
    class SolutionUsing01Recursion {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            // Using 01 recursion with backtracking approach
            this.result = new ArrayList<>();
            helper(nums, 0, new ArrayList<>());
            return result;
        }

        public void helper(int[] nums, int i, List<Integer> path){
            if(i==nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            path.add(nums[i]);
            helper(nums, i+1, new ArrayList<>(path));
            path.remove(path.size()-1);
            helper(nums, i+1, new ArrayList<>(path));
        }
    }

    //Using approach for loop with backtracking
    // time complexity = O(2^m+n)
    //space complexity = O(h)
    class SolutionUsingForloop {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            // Using for loop with recursion and backtracking approach
            this.result = new ArrayList<>();
            helper(nums, 0, new ArrayList<>());
            return result;
        }

        public void helper(int[] nums, int pivot, List<Integer> path){
            result.add(new ArrayList<>(path));
            for(int i = pivot; i<nums.length; i++){
                path.add(nums[i]);
                helper(nums, i+1, new ArrayList<>(path));
                path.remove(path.size()-1);
            }

        }
    }

    //Using approach two for loop without recursion
    // time complexity = O(2^m+n)
    //space complexity = O(h)
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            this.result = new ArrayList<>();
            result.add(new ArrayList<>());
            for(int i = 0; i<nums.length; i++){
                int size = result.size(); //need to define here else we will get infinite loop issue
                for(int j =0; j< size; j++){
                    List<Integer> li = new ArrayList<>(result.get(j));
                    li.add(nums[i]);
                    result.add(li);
                }
            }
            return result;
        }
    }
}