//Time Complexity:O(N*2^N) where N is the length of the nums array.
//Space Complexity:O(N)
//In this problem, I'll be sorting the input nums array to create unique combinations. I'll be creating a temp list to hold the values at that ionstant. In the backtrack function, I'll add the temp list to the result list each time I enter the function. I'll then iterate over the input array and call the function recursively to find the unique subarrays.
//This code was executed successfully and got accepted in leetcode. 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,temp,nums,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp,int[] nums, int i){
        
    
        res.add(new ArrayList<>(temp));
            
        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            backtrack(res,temp,nums,j+1);
            temp.remove(temp.size()-1);
        }
    }
}