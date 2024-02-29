//TimeComplexity: O(2^n)

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void helper(int[] nums, int pivot, List<Integer> path) {
       if(pivot == nums.length+1) {
           return;
       }
       result.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++) {
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        //Without recursion
        //Time Complexity: O(2^n)
        /*List<Integer> path = new ArrayList<>();
        result.add(path);
        for(int i=0; i< nums.length;i++) {
            int size = result.size();
            for(int j=0; j<size;j++) {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }*/

        // For loop based recursion
        helper(nums,0,path);
        return result;
    }
}