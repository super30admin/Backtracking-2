class Solution {
   
    List<List<Integer>>  result;
       
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0 ) return result;
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(int[] nums,List<Integer> temp,int index){
        
        //logic
        result.add(new ArrayList<>(temp));
        for(int i = index ; i < nums.length ; i ++){
        //action
        temp.add(nums[i]);
        //recurse
         backtrack(nums,temp,i+1); // starting from pivot collect all the elements 
        //backtrack
         temp.remove(temp.size() - 1);   
        }
    }
}

//Time : O(2^n *n)
//Space: temp is the only list created hence O(n)