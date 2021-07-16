// Time Complexity : Exponential
// Space Complexity : O(n)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        //and null set
        result.add(new ArrayList<>());
        //take one num and add to each of the existing sets
        for(int num : nums){
            int size = result.size();
            for(int i = 0; i < size; i++){
                List copy = new ArrayList<>(result.get(i));
                copy.add(num);
                result.add(copy);
            }
        }
        return result;
    }
}