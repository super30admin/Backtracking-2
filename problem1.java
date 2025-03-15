// Iterative
// TC : O(2^N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int sz = result.size();
            for(int j = 0; j < sz; j++){
                List<Integer> newlist = new ArrayList<>(result.get(j));
                newlist.add(nums[i]);
                result.add(new ArrayList<>(newlist));
            }
        }
        return result;
    }
}

// // // for loop based recursion
// // TC: O(2^N)

// class Solution {
//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {
//         if(nums == null || nums.length == 0) return new ArrayList<>();
//         result = new ArrayList<>();
//         helper(nums, 0, new ArrayList<>());
//         return result;
//     }
//     public void helper(int[] nums, int index, List<Integer> path){
//         if(index > nums.length) return;
//         result.add(new ArrayList<>(path));
//         for(int i = index; i < nums.length; i++){
//             List<Integer> newpath = new ArrayList<>(path);
//             newpath.add(nums[i]);
//             helper(nums, i + 1, newpath);
//         }
//     }
// }

// backtracking
// // // 0-1 based recursion
// // TC: O(2^N) where N is length of array nums
// //SC: O(H) or O(N) where H is height if recursive stack which is N

// class Solution {
//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {
//         if(nums == null || nums.length == 0) return new ArrayList<>();
//         result = new ArrayList<>();
//         helper(nums, 0, new ArrayList<>());
//         return result;
//     }
//     public void helper(int[] nums, int index, List<Integer> path){
//         if(index == nums.length){
//             result.add(new ArrayList<>(path));
//             // result.add(path);
//             return;
//         }
        
//         helper(nums, index + 1, path);
//         path.add(nums[index]);
//         helper(nums, index + 1, path);
//         path.remove(path.size() - 1);

//         // helper(nums, index + 1, new ArrayList<>(path));
//         // path.add(nums[index]);
//         // helper(nums, index + 1, new ArrayList<>(path));
//     }
// }
