//Time Complexity: O(2^n).
//Space Complexity: O(1).


// class Solution {
//     List<List<Integer>> result; 
//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList<>();
//         if(nums.length == 0) return result;
        
        
//         helper(nums, 0, new ArrayList<Integer>());
//     return result;
//     }
    
//     private void helper(int[] nums, int i, ArrayList<Integer> path){
//         //base
//         if(i == nums.length){
//             result.add(new ArrayList<>(path));
//             return;
//         }
        
//         //logic
//         //case 0: do not choose
//         helper(nums, i+1, new ArrayList<>(path));
        
//         //case 1: choose
//         path.add(nums[i]);
//         helper(nums, i+1, new ArrayList<>(path));
        
//         path.remove(path.size()-1);
//     }
// }


class Solution {
    List<List<Integer>> result; 
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0) return result;
        
        
        helper(nums, 0, new ArrayList<>());
    return result;
    }
    
    private void helper(int[] nums, int index, ArrayList<Integer> path){
        //base
      
        //logic
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
        
    }
}