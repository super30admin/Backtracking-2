//Time complexity - O(n*2^n)  n- for no of cloning times 2^n for computation
//Space Complexity - O(n)
//works in leetcode
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subSet = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(subSet);

        subsets(nums, 0);

        return result;
    }

    private void subsets(int[] nums, int index)
    {

        for(int i=index; i< nums.length; i++){
            subSet.add(nums[i]);
            result.add(new ArrayList<>(subSet));
            subsets(nums, i+1);
            subSet.remove(subSet.size()-1);

        }

    }


}