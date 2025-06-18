// Time Complexity - 2^n
// Space Complexity - O(1)

/* Approach : For each number, you have two choices: either include it in the group or leave it out. 
You start with an empty group and go through each number, deciding whether to add it or not. 
If you add it, you keep going with the next number. If you don't add it, you also keep going 
with the next number. This way, you explore all possible combinations. Once you've considered 
all numbers, you save the current group. By doing this for every number, you end up with all 
possible groups you can make from the list.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),result);
        return result;
        
    }
    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result){
        //base case : if we've considered all elements, add the current path to the result
        if(idx == nums.length){     
            result.add(new ArrayList<>(path));
            return;
        }
        //dont choose the current element
        helper(nums, idx+1,path, result );
        //choose the current element
        path.add(nums[idx]);
        helper(nums, idx+1,path, result );
        //Backtrack : remove the last added element
        path.remove(path.size() - 1);
    }
}

// Time Complexity - 2^n
// Space Complexity - O(1)

/*Approach : This solution uses an iterative approach to generate all possible subsets of the input 
array. It starts with an initial list containing just the empty subset. For each number in the input 
array, it iterates through all existing subsets and creates new subsets by adding the current number 
to each of them. This way, it builds up all possible combinations step by step. By the end of the 
process, the result list contains all subsets of the input array, including the empty subset and 
the array itself. This method ensures that no subsets are missed and that all possible combinations 
are considered.
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0)return result;                              // If the input array is empty, return the empty result list
        result.add(new ArrayList<>());                                  // Start with an empty subset
        for(int i=0; i<nums.length; i++){                               // Iterate through each number in the input array
            int size = result.size();
            for(int j=0; j<size; j++){                                  // For each existing subset, create a new subset that includes the current number
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}