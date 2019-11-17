/* 78. Subsets
Time Complexity: O(2^n) exponential time complexity
Space Complexity: O(n^2)
whenever you are adding temp list to the result list add a copy of it, since 
temp list keeps changing.
maximum number of elements in the temporary ArrayList at one point of time 
is 'n'
*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0)
            return result;

        // Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> temp){
        result.add(new ArrayList<>(temp));

        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            System.out.println(temp);
            backtrack(nums, i+1, temp);
            //remove whatever was added - backtrack next pick [2] so
            temp.remove(temp.size() - 1);
        }
    }
}