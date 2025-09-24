class Solution {
    List<List<Integer>>res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums,int index,List<Integer>path){
        //logic
        res.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}