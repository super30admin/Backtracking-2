class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {    
        //2nd approcah without recursion
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0 ;i<nums.length;i++)
        {  
            int k = result.size();
           for(int j = 0 ; j< k;j++)
            {    
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]); 
               result.add(temp);  
            }
              
        }
        return result;
    }

}

//Time complexity: o(n)
//space complexity: o(1)

//backtracking

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0, new ArrayList<>());
        return result;
 
    }
    private void helper(int[] nums, int index, List<Integer> path)
    {
        base
        if(index == nums.length)
        {
            return;
        }
        
        for loop
        result.add(new ArrayList<>(path));
        for(int i = index;i< nums.length ;i++)
        {
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}

//time complexity: 2^n
//sapce complexity: o(n)