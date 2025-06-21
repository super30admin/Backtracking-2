//o-1 recursion without backtracking. Using Deepcopy. Very slow - not recommended.

// //o-1 recursion with backtracking
// //TC = O(2^n)
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         helper(nums,0,new ArrayList<>(), result);
//         return result;
//     }
//     private void helper(int[]nums, int idx, List<Integer>path, List<List<Integer>> result){
//         //base
//         if(idx==nums.length){
//             result.add(new ArrayList<>(path));
//             return;
//         }
//         //logic
//         //dont choose
//         helper(nums,idx+1,path,result);
//         //choose
//         //action
//         path.add(nums[idx]);
//         //recurse
//         helper(nums,idx+1,path,result);
//         //backtrack
//         path.remove(path.size()-1);
//     }
// }

//for loop based recursion with backtracking
//TC = O(2^n)
//SC = O(2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,new ArrayList<>(), result);
        return result;
    }
    private void helper(int[]nums, int pivot, List<Integer>path, List<List<Integer>> result){
        //base
        if(pivot > nums.length) return;
        //deepcopy of path
        result.add(new ArrayList<>(path));
        //logic //pivot is static, i is moving
        for(int i=pivot; i<nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path, result);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}

