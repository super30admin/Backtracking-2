// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Backtracking
 */
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    //O(2^n )
    private void helper(int[] nums, int pivot, List<Integer> path) {

        //base
        //O(n)
        if(pivot == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        helper(nums, pivot+1, path);

        path.add(nums[pivot]);
        helper(nums, pivot+1, path);
        path.remove(path.size()-1);
    }
}


/*
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {

        //base
//        result.add(new ArrayList<>(path));
//        if(pivot == nums.length) return;     //IT IS FINE EVEN IF WE DO NOT WRITE THIS LINE AS IT IS HANDLED BY FOR LOOP

        if(pivot > nums.length) return;

        result.add(new ArrayList<>(path));

        for(int i=pivot; i<nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}*/


//TC : O(n*(2^n))
//SC : O(N)
/*class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++) {
            int size = result.size();
            for(int j=0; j<size; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }

        return result;
    }
}*/
