//Time Complexity: O(2^N)
//Space Complexity: O(2^N)

//<-----Backtrack----->
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //edge
        if(nums == null || nums.length ==0) return result;        
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int start){              
        //logic
        result.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }        
    }
}

<----Recursive--->
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //edge
        if(nums == null || nums.length ==0) return result;        
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int i){              
        //logic
        if(i == nums.length){
            result.add(temp);
            return;
        }
        helper(nums, new ArrayList<>(temp), i+1);
        
        temp.add(nums[i]);
        helper(nums, temp, i+1);
    }
}