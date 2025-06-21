class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // helper_tochooseFirst(nums, 0, new ArrayList<>(), result);
        helper_notTochooseFirst(nums, 0, new ArrayList<>(), result);
        //helper_01recursion(nums, 0, new ArrayList<>(), result);
        //helper_forRecursion(nums, 0, new ArrayList<>(), result);

        return result;

    }

    private void helper_tochooseFirst(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
        //base 
        if (idx >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //to choose
        List<Integer> li = new ArrayList<>(path);
        li.add(nums[idx]);
        helper_tochooseFirst(nums, idx + 1, li, result);
        //not choose
        helper_tochooseFirst(nums, idx + 1, path, result);
        
      
    }

    private void helper_notTochooseFirst(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
          //base 
        if (idx >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper_notTochooseFirst(nums, idx + 1, new ArrayList<>(path), result);
        //to choose
        path.add(nums[idx]);
        helper_notTochooseFirst(nums, idx + 1, new ArrayList<>(path), result);
        

    }

    private void helper_01recursion(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
        //base 
        if (idx >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper_01recursion(nums, idx + 1, path, result);
        //to choose
        path.add(nums[idx]);
        helper_01recursion(nums, idx + 1, path, result);
        //backtrack
        path.remove(path.size() - 1);

    }

    private void helper_forRecursion(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result) {
        //base 
        //logic
        result.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper_forRecursion(nums, i + 1, path, result);
            //backtrack
            path.remove(path.size() - 1);
        }
    }

}