
// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//Have two case: select the num and then remove the num (which is considered as unselected(backtrack)) and recursively call it , if the index is equals or grater then the nums length; add to the result;
// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return result;
    }
    private void dfs(int [] nums, int index, List<Integer> ls){
        // base
        if(index <= nums.length){
            result.add(new ArrayList<>(ls));
        }
        // logic
        for(int i = index; i < nums.length; i++){
            ls.add(nums[i]);
            dfs(nums, i+1, ls);
            ls.remove(ls.size()-1);
        }
    }
}

// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList<>();
//         dfs(nums, 0, new ArrayList<>());
//         return result;
//     }
//     private void  dfs(int [] nums, int index, List<Integer> ls){
//         // base
//         if(nums.length == index){
//             result.add(new ArrayList<>(ls));
//             return;
//         }
//         // logic
//         // select
//         ls.add(nums[index]);
//         dfs(nums, index+1, ls);
//         ls.remove(ls.size()-1);
//         dfs(nums, index+1, ls);
//     }
// }
