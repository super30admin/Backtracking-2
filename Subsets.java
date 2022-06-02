//Backtracking solution

class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path){
        //base
        if(idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(nums, idx+1, path);
        //choose
        path.add(nums[idx]);
        helper(nums, idx+1, path);
        //backtrack
        path.remove(path.size()-1);
    }
}

//For loop based recursive solution
class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path){

        result.add(new ArrayList<>(path));
        for(int i = idx; i< nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}