// Time and Space Complexity: n2^n

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),result);
        return result;
    }

    private void helper(int[] nums,int pivot,List<Integer> path,List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path,result);
            path.remove(path.size()-1);
        }
    }
}