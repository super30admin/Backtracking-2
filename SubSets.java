/*Time Complexity: O(2^n)
Space Complexity: O(n^2)
*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0)
            return result;

        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> temp){
        result.add(new ArrayList<>(temp));

        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            System.out.println(temp);
            backtrack(nums, i+1, temp);
			//backtrack in the next line
            temp.remove(temp.size() - 1);
        }
    }
} 