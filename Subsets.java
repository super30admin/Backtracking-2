//Time: O(n * 2^n)
//Space: O(n)
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList<>();
//         if(nums == null || nums.length == 0)
//             return result;
        
//         helper(nums, 0, new ArrayList<>());
        
//         return result;
//     }
    
//     private void helper(int[] nums, int index, List<Integer> path){
//         if(index == nums.length){
//             result.add(new ArrayList<>(path));
//             return;
//         }
        
//         //do not choose
//         helper(nums, index + 1, path);
//         //choose
//         path.add(nums[index]);
//         helper(nums, index + 1, path);
//         //backtrack
//         path.remove(path.size() - 1);
//     }
// }

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
        
        
    }
}

// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList<>();
//         if(nums == null || nums.length == 0)
//             return result;
//         result.add(new ArrayList<>());
        
//         for(int i = 0; i < nums.length; i++){
//             int size = result.size();
//             for(int j = 0; j < size; j++){
//                 List<Integer> newList = new ArrayList<>(result.get(j));
//                 newList.add(nums[i]);
//                 result.add(newList);
//             }
//         }
//         return result;
//     }
// }
