/*
0/1 recursion without backtracking
TC: O(N * 2^N)
SC: O(N * 2^N)
*/
class SubSets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path){
        //base
        if(idx == nums.length){
            result.add(path);
            return;
        }
        //logic
        //choose
        List<Integer> li = new ArrayList<>(path);
        li.add(nums[idx]);
        helper(nums, idx+1, li);
       // li.remove(path.size() - 1);
        //not choose
        helper(nums, idx+1, new ArrayList<>(path));

    }
}

/*
for-loop based recursion with backtracking
TC: O(N * 2^N)
SC: O(N * 2^N)
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int pivot, List<Integer> path){
        //base
        //logic
        result.add(new ArrayList<>(path));
        for(int i = pivot; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size() - 1);
        }
    }
}

/*
Without recursion
TC: O(N * 2^N)
SC: O(1)
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums.length == 0) return result;
        for(int i = 0 ; i< nums.length; i++){
            int size = result.size();
            for(int j =0; j< size ; j++){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);

            }
        }
        return result;
    }
}