//Time complexity:O(n^n)
//Space complexity:O(length of set)
//Ran on leetcode: YES
//Solution with comments:

class Solution {
    List<List<Integer>> output= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        output.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);//adding individual number in set
            output.add(new ArrayList<>(list));
            backtrack(nums,i,list);
        }
        return output;
    }
    
    public void backtrack(int[] nums, int index, List<Integer> list){
       // System.out.println(index);
        if(index>=nums.length) 
            return;
        for(int i=index+1;i<nums.length;i++){
            
            list.add(nums[i]);//appending next number in set with previous
            output.add(new ArrayList<>(list));
            backtrack(nums,i,list);
            list.remove(list.size()-1);
            
        }
    }
}