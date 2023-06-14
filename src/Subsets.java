// ******************** For loop with backtracking ********************
// Time Complexity:           O(n * 2^n)
// Space Complexity:          O(n)
// where n is length of given String
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


class SolutionSubsets {

   List<List<Integer>> result;

   public List<List<Integer>> subsets(int[] nums) {
       result = new ArrayList<>();
       subsets(nums, 0, new ArrayList<>());
       return result;
   }

   private void subsets(int[] nums, int index, List<Integer> list) {

       result.add(new ArrayList<>(list));

//         // we can add not choose case externally as well instead of the above line
//         if(index == nums.length) {
//             result.add(new ArrayList<>(list));
//             return;
//         }
//         subsets(nums, nums.length, list);

       for(int i=index; i<nums.length; i++) {
           // ACTION
           list.add(nums[i]);
           // RECURSION
           subsets(nums, i+1, list);
           // BACKTRACKING and NOT CHOOSE
           list.remove(list.size()-1);
       }
   }
}






// // ******************** without recursion, iterative approach ********************
// // ****************************** Another Approach ******************************

// class Solution {

//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {

//         result = new ArrayList<>();                                        // defining result
//         result.add(new ArrayList<>());                                     // Adding [] in result
        
//         for(int i=0; i<nums.length; i++) {

//             int val = nums[i];                                             // getting current value to be added in all lists in result

//             int size = result.size();                                      // getting size of result

//             for(int j=0; j<size; j++) {                                    // adding current value to all lists in result

//                 List<Integer> temp = new ArrayList<>(result.get(j));       // getting all lists one by one
//                 temp.add(val);                                             // adding current value
//                 result.add(temp);                                          // adding updated list in result

//             }

//         }

//         return result;
        
//     }

// }









// // ******************** For loop without backtracking ********************
// // ****************************** Another Approach ******************************
// // Time Complexity:           O(n * 2^n)
// // Space Complexity:          O(n)
// // where n is length of given String

// // without backtracking, creating new list for every recursion

// class Solution {

//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {

//         result = new ArrayList<>();
//         helper(nums, 0, new ArrayList<>());
//         return result;
        
//     }

//     private void helper(int[] nums, int index, List<Integer> path) {

//         // base
//         // logic
//         result.add(path);

//         // for loop
//         for(int i=index; i<nums.length; i++) {

//             // choose
//             List<Integer> temp = new ArrayList<>(path);
//             temp.add(nums[i]);
//             helper(nums, i+1, temp);

//         }

//     }

// }






// // ******************** simple choose, no choose with backtracking ********************
// // ****************************** Another Approach ******************************
// // Time Complexity:           O(n * 2^n)
// // Space Complexity:          O(n)
// // where n is length of given String

// import java.util.ArrayList;
// import java.util.List;

// public class Subsets {
//     public static void main(String[] args) {
//         SolutionSubsets obj = new SolutionSubsets();
//         int[] nums = {1,2,3};
//         List<List<Integer>> list = obj.subsets(nums);
//         System.out.println(list);
//     }
// }

// class SolutionSubsets {

//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {
//         result = new ArrayList<>();
//         subsets(nums, 0, new ArrayList<>());
//         return result;
//     }

//     private void subsets(int[] nums, int index, List<Integer> list) {
//         if(index == nums.length) {
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         // ACTION
//         list.add(nums[index]);
//         // RECURSION
//         subsets(nums, index+1, list);
//         // BACKTRACKING
//         list.remove(list.size()-1);

//         // not choose
//         subsets(nums, index+1, list);
//     }
// }






// // ******************** simple choose, no choose without backtracking ********************
// // ****************************** Another Approach ******************************
// // Time Complexity:           O(n * 2^n)
// // Space Complexity:          O(n)
// // where n is length of given String

// // without backtracking, creating new list for every recursion
// // not choose first

// class Solution {

//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {

//         result = new ArrayList<>();
//         helper(nums, 0, new ArrayList<>());
//         return result;
        
//     }

//     private void helper(int[] nums, int index, List<Integer> path) {

//         // base
//         if(index == nums.length) {
//             result.add(path);
//             return;
//         }

//         // recursion

//         // not choose
//         helper(nums, index+1, new ArrayList<>(path));

//         // choose
//         path.add(nums[index]);
//         helper(nums, index+1, new ArrayList<>(path));

//     }

// }






// // ******************** simple choose, no choose with backtracking ********************
// // ****************************** Another Approach ******************************
// // Time Complexity:           O(n * 2^n)
// // Space Complexity:          O(n)
// // where n is length of given String

// // without backtracking, creating new list for every recursion
// // choose first

// class Solution {

//     List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {

//         result = new ArrayList<>();
//         helper(nums, 0, new ArrayList<>());
//         return result;
        
//     }

//     private void helper(int[] nums, int index, List<Integer> path) {

//         // base
//         if(index == nums.length) {
//             result.add(path);
//             return;
//         }

//         // recursion

//         // choose
//         List<Integer> temp = new ArrayList<>(path);
//         temp.add(nums[index]);
//         helper(nums, index+1, temp);

//         // not choose
//         helper(nums, index+1, new ArrayList<>(path));

//     }

// }
