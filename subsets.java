class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr= new ArrayList<>();

        result.add(new ArrayList<>());
        helper(nums,0,curr);
        return result;
    }



    public void helper(int[]nums,int index,List<Integer> curr){
        if(index>=nums.length) return;



        List<Integer>tempArray=new ArrayList(curr);
        int temp=nums[index];
        tempArray.add(temp);
        result.add(tempArray);
        helper(nums,index+1,tempArray);
        helper(nums,index+1,curr);

    }

}