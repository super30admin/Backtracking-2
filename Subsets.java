// Time Complexity : O(2^n)
// Space Complexity : O(n * 2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int idx, List<Integer> path){
        //base
        if(idx >= nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        helper(nums,idx+1,path);
        path.add(nums[idx]);
        helper(nums,idx+1,path);
        path.remove(path.size()-1);
    }
}*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int idx, List<Integer> path){
        for(int i = idx;i<nums.length;i++){
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

/*class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
            int size =result.size();
            for(int j = 0;j<size;j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}*/
