// 0-1 recursion 
// time complexity - O(n × 2ⁿ)
//space complexity - O(n)
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {
//         this.result = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         helper(nums, 0, path);
//         return result;
//     }
//     private void helper(int[] nums, int i,List<Integer> path){
//         //base
//         if(i==nums.length)
//         {
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         //logic 
//         //0
//         helper(nums,i+1,path);
//         path.add(nums[i]);
//         helper(nums,i+1,path);
//         path.remove(path.size()-1);
//     }
// }

//Time Complexity: O(n × 2ⁿ) 
//Space Complexity: O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums,path,0);
        return result;
    }
    private void helper(int[] nums,List<Integer> path,int pivot){
        result.add(new ArrayList(path));
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,path,i+1);
            path.remove(path.size()-1);
        }
    }
}