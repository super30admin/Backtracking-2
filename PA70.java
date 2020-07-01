//LeetCode : 78. Subsets
//Time Complexity: O(N*2^N)  
//Space Complexity: O(N*2^N)

 //Backtracking solution
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res= new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return res;
        }
         helper(nums, new ArrayList<Integer>(),0);
         return res;
    }
    public void helper(int[] nums, List<Integer> temp, int i){
        if(i==nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        //not select
        helper(nums, temp,i+1);
        //select
        temp.add(nums[i]);
        helper(nums, temp,i+1);
        //Backtracking
        temp.remove(temp.size()-1);
    }
}

==============================================
//Recursive solution without Backtracking:

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res= new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return res;
        }
         helper(nums, new ArrayList<Integer>(),0);
         return res;
    }
    public void helper(int[] nums, List<Integer> temp, int i){
        if(i==nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        //not select
        helper(nums, new ArrayList(temp),i+1);
        //select
        temp.add(nums[i]);
        helper(nums, new ArrayList(temp),i+1);
   
        
    }
}