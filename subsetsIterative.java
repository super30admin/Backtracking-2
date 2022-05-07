//tc N ^ 2
//SC N

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        // we first check the number of elements in result array then append all list in result with the current 
        // number in iteration in outer for loop
        // good to observe that we can't put result.size() directly in line 17 
        // it will result in infinite loop cuz we are meddling with result inside loop and size keeps increasing 
        // so forever j will be less than result.size
        // it is hence crucial to use a varfiable to save the state and progress with the logic
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int size = result.size();
            for(int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }
}