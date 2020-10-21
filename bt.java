//Time - 
//Space -

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res =  new ArrayList<>();
        int len = nums.length;
       
        if (nums.length == 0){
            return res;
        }
            backTrack(res,nums,new ArrayList<Integer>(),0);
        return res;
    }

    public static void backTrack(List<List<Integer>> res,int [] nums ,List<Integer> tmp, int index) {
        res.add(new ArrayList<>(tmp));
            for (int i = index; i < nums.length; i++) {
                tmp.add(nums[i]);
                backTrack(res, nums, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        
    }
}
