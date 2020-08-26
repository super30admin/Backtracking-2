//time complexity O(n2^n)
//space complexity O(n)
//APPRAOCH: Backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> temp){
        //base

        //logic
	//initially add the empty list since that's 
	//also a part of subsets
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            //action
            temp.add(nums[i]);

            //recurse
            backtrack(nums, i + 1, temp);

            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
}

//time complexity O(n2^n)
//space complexity O(2^n)
//APPROACH: Backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> temp){
        //base
        if(index == nums.length) {
            result.add(temp);
            return;
        }
        //logic
        //dont choose
        helper(nums, index + 1, new ArrayList<>(temp));
        //choose
        temp.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(temp));
    }
}
