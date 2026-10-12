//Time Complexity : O(n * 2^n)
//Space Complexity: O(n)
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int size = result.size();
            for(int j = 0; j < size; j++) {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }
}
