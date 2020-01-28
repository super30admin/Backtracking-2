TC : O(2**n) - exponential time
SC : O(n)

class Solution {
    List<List<Integer>> li = new ArrayList<>();
    Set<List<Integer>> st = new HashSet<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return li;
        
        backtrack(nums, 0, new ArrayList<>());
        
        return li;
    }
    
    private void backtrack(int[] nums, int idx, List<Integer> l)
    {
        //Base
        if(idx == nums.length) return;
        
        
        //Logic
        for(int j = idx; j < nums.length; ++j)
        {
            //not choose
            backtrack(nums, j + 1, l);
            
            if(!st.contains(l))
                li.add(new ArrayList<>(l));
            
            st.add(new ArrayList<>(l));
            
            //choose
            l.add(nums[j]);
            
            backtrack(nums, j + 1, l);
            
            if(!st.contains(l))
                li.add(new ArrayList<>(l));
            
            st.add(new ArrayList<>(l));
            
            l.remove(l.size() - 1);
            
        }
    }
}
