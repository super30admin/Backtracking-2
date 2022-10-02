import java.util.*;

// TC : n * 3^n (exponential) where n is the number of nodes
// SC : n * 3^n (exponential)

public class Subsets {

    // Brute Force Approach using 0-1 recursion
    static class Solution1 {
        List<List<Integer>> result ;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            helper(nums,0,new ArrayList<>());
            return result;
        }

        private void helper(int[] nums, int i, List<Integer> path) {
            // base
            if (i==nums.length){
                result.add(path);
                return;
            }

            // logic
            // dont choose case
            helper(nums,i+1, new ArrayList<>(path));

            // choose case
            path.add(nums[i]);
            helper(nums,i+1, new ArrayList<>(path));

        }
    }

    // Backtracking Approach 0-1 recursion
    static class Solution2 {
        List<List<Integer>> result ;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            helper(nums,0,new ArrayList<>());
            return result;
        }

        private void helper(int[] nums, int i, List<Integer> path) {
            // base
            if (i==nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            // logic
            // dont choose case
            helper(nums,i+1, path);

            // choose case
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    // For-loop based recursion using Brute force
    static class Solution3 {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            helper(nums,0,new ArrayList<>());
            return result;
        }

        private void helper(int[] nums, int pivot , List<Integer> path){


            //base

            //logic
            result.add(path);

            for(int i = pivot ; i < nums.length ; i++){

                List<Integer> temp = new ArrayList<>(path);
                temp.add(nums[i]);
                helper(nums,i+1,temp);
            }
        }
    }

    // For-loop based recursion using Backtracking
    static class Solution4 {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            helper(nums,0,new ArrayList<>());
            return result;
        }

        private void helper(int[] nums, int pivot , List<Integer> path){


            //base

            //logic
            result.add(new ArrayList<>(path));

            for(int i = pivot ; i < nums.length ; i++){

                //action
                path.add(nums[i]);
                //recurse
                helper(nums,i+1,path);
                //backtracking
                path.remove(path.size()-1);
            }
        }
    }

    // Without recursion
    static class Solution5 {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums){

            result = new ArrayList<>();

            //adding an empty ArrayList in the result
            result.add(new ArrayList<>());

            for(int i = 0 ; i < nums.length ; i++){
                int size = result.size();
                for(int j = 0 ; j < size ; j++){
                    List<Integer> temp = new ArrayList<>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
            return result;
        }
    }

}
