class Solution {
    
    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        subsetsHelper(nums, 0, new ArrayList<>());
        return results;
    }
    
    private void subsetsHelper(int nums[], int start, List<Integer> subset)
    {
        System.out.println("Subset result:"+subset);
        results.add(new ArrayList<>(subset));
        
        for (int i=start; i<nums.length; i++)
        {
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset);
            System.out.println("Subset before remove:"+subset);
            subset.remove(subset.size() - 1);
            System.out.println("Subset after remove:"+subset);
        }
    }
}
