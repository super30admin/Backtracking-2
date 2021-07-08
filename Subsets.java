class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        this.path = new ArrayList<>();
        System.out.println(res.toString());
        backtrack(nums, 0);
        return res;
    }
    
    public void backtrack(int[] nums, int index){
        //base
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        res.add(new ArrayList<>(path));
        //logic
        for(int i=index; i<nums.length; i++){
            //action
            path.add(nums[i]);
            //recursion
            backtrack(nums, i+1);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}
