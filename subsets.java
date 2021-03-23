// Time Complexity :
O(2 ^ n * n) n is the length of the input nums
// Space Complexity :
O(n) It is the maximum size of the subset that is stored in the temp list
// Did this code successfully run on Leetcode :
yes
// Any problem you faced while coding this :
yes

// Your code here along with comments explaining your approach


/*
TC: O(2 ^ n * n) n is the length of the input nums
SC: O(n) It is the maximum size of the subset that is stored in the temp list
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //Define final result
        List<List<Integer>> result = new ArrayList<>();
        //define an inermediate arrayList
        List<Integer> temp = new ArrayList<>();
        //call the helper function
    for(int size=0;size<nums.length+1;size++){
        helper(nums,0,result,temp,size);  
    }
    
        return result;
            
    }
    
    private void helper(int[] nums,int ind,List<List<Integer>> result,List<Integer> temp,
                    int size){
    //Basecase
    if(size == temp.size()){
        result.add(new ArrayList<>(temp));
        return;
    }
    for(int i=ind;i<nums.length;i++){
        temp.add(nums[i]);
        helper(nums,i+1,result,temp,size); 
        temp.remove(temp.size()-1);
    }
    
    }
}