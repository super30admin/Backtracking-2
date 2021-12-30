// Time Complexity:O(n×2^n)
// space complexity :O(n)
// leetcode : success
class Solution {
    List<List<Integer>> result;
   
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
       
        for(int k = 0 ; k <= nums.length ; k++){
             helper(nums,0,k,new ArrayList<Integer>());
        }
        return result;
    }
    
    private void helper(int[] nums , int index ,int size, List<Integer> currlist){
        
        if(currlist.size() == size){
            result.add(new ArrayList(currlist));
            return;
        }
        
        for(int i = index ; i < nums.length ; i++){
            
            currlist.add(nums[i]);
            
            helper(nums,i+1,size,currlist);
            
            currlist.remove(currlist.size()-1);
        }
        
       
    }
}