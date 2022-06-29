/ O(2^n) time ||   O(2^n) space 

class Solution {

         List<List<Integer>> result ;
    public List<List<Integer>> subsets(int[] nums) {

        result= new ArrayList<>();
        helper(nums,0,new ArrayList<>())   ;

        return result;


    }

    private void helper(int [] nums , int i , List<Integer> path){

        //base 

        if(i==nums.length){
                result.add(path);
            return;
            }
        //logic
        // dont choose
        helper(nums,i+1,new ArrayList<>(path));

        //choose 
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path));
        // backtrack 
        path.remove(path.size()-1);
    }
}