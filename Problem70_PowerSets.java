class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        //base case
        if(list == null)
            return;
        //adding empty list as the first output to the list
        list.add(new ArrayList<>(tempList));
        //starting from start of nums till the max length
        for(int i = start; i< nums.length; i++){
            //add
            tempList.add(nums[i]);
            //recursive call
            backtrack(list, tempList, nums, i+1);
            //backtrack
            tempList.remove(tempList.size()-1);
        }
    }
}