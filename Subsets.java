/*
The time complexity is O(2^N) and the space complexity is O(N)

The intuition here is to to iterate from start to the end of the input list and making the choice of selecting or not selecting a number.

Yes, the solution passed all the test cases in leet code.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> inside = new ArrayList<>();
        retList.add(inside);
        if(nums.length==0){return retList;}
        backtracking(retList,inside,nums,0);
        return retList;
    }

    public void backtracking(List<List<Integer>> retList,List<Integer> list,int[] nums,int start){
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            retList.add(new ArrayList<>(list));
            backtracking(retList,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}