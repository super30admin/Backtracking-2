class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path){


        result.add(new ArrayList<>(path));
        for(int i= pivot; i< nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }

    }
}


/*

TC : O(2^n)

Sc : O(n)


  */