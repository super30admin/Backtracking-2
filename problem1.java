//TC = (2^N)*N
//SC = N

class Solution {

    private List<List<Integer>> sets;
    private List<Integer> set;

    public List<List<Integer>> subsets(int[] nums) {

        sets = new ArrayList<>();
        set = new ArrayList<>();

        subsets(nums, 0);

        return sets;
    }

    private void subsets(int[] nums, int index) {

        sets.add(new ArrayList<>(set));

        for (int i = index; i < nums.length; i++) {
            set.add(nums[i]);
            subsets(nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}

/*
 * class Solution {
 * public List<List<Integer>> subsets(int[] nums) {
 * List<List<Integer>> sets = new ArrayList<>();
 * sets.add(new ArrayList<>());
 * for (int num : nums){
 * int size = sets.size();
 * 
 * for (int i = 0; i < size; i++){
 * 
 * List<Integer> clonedSet = new ArrayList<>(sets.get(i));
 * clonedSet.add(num);
 * sets.add(clonedSet);
 * }
 * }
 * return sets;
 * }
 * }
 */
