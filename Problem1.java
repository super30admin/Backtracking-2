// Time: O(2^N)
// Space: O(N)

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        
        res = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return res;
    }
  
    public void helper(int[] nums, int idx , List<Integer> path){
        System.out.println(path);
        res.add(new ArrayList<>(path));
        for(int i =idx ; i< nums.length ; i++){
            path.add(nums[i]);
            helper(nums,i+1, path);
            path.remove(path.size()-1);
        }
    }
}