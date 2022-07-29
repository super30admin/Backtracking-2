//Time Complexity:2^n where n is the subset added to the list
//Space complexity:O(List of Subset)
//Facebook Interview
//Iterative
//Given an array set [1,2,3] for this consider choose and not choose based on the index position value .Do not choose when I don't add anything to my path and choose when I add the current element added to the list path when I don't have any element that is the base case it return the empty arraylist as result.
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return result;
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                List<Integer> newlist = new ArrayList<>(result.get(j));
                newlist.add(nums[i]);
                result.add(newlist);
            }
        }
        return result;
    }
}