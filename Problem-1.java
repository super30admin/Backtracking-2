package Backtracking-2;

public class Problem-1 {
        List<List<Integer>> res;
        List<Integer> path;
    
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for(int i = 0; i < nums.length; i ++){
                int size = res.size();
                for(int j = 0; j< size; j++){
                    List<Integer> li = new ArrayList<>(res.get(j));
                    li.add(nums[i]);
                    res.add(li);
                }
            }
            
            return res;
        }
        
}
