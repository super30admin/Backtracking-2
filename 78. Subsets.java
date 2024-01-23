class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        if(nums.length == 0) return Collections.emptyList();

        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());

        for(int num : nums){
            List<List<Integer>> local = new LinkedList<>();
            for(List<Integer> list : result){
                List<Integer> c1 = new LinkedList<>(list);
                c1.add(num);
                local.add(c1);
            }
            result.addAll(local);
        }
        return result;
        
    }
}
