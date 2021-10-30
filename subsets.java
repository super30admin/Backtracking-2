//Time complexity:-O(n*2^n)
//Spacecomplexity:- 0(1).
//Did it run on leetcode:- yes.
//What was the problem you faced?:- got many compilation errors and runtime erros.
//your code with explanation:here as empty set,one element and all subelements are also subsets adding them before backtracking
//and then applying backtracking with reversal operation to be removal of array list.

class Solution {
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track=new ArrayList<>();
        subsetshelper(nums,0,track);
        
        
    return result;}
    private void subsetshelper(int[] nums,int index,List<Integer> track){
        if(index>nums.length){
            return;
        }
        result.add(new ArrayList<>(track));
        for(int i=index;i<nums.length;i++){
            track.add(nums[i]);
            subsetshelper(nums,i+1,track);
            track.remove(track.size()-1);
        }
    }
}