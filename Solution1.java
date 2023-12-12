//TC : O(2^n)
//SC -O(n)
//Subsets

class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        result=new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    //for loop based recursion
    //at every node we get solution
    private void helper(int[] nums,int pivot,List<Integer> path)
    {

        //no need of base condition
       //at every node , there is a solution, add it to result
       result.add(path);
        for(int i=pivot;i<nums.length;i++)
        {
            path.add(nums[i]);
            helper(nums,i+1,new ArrayList<>(path));
            path.remove(path.size()-1);
        }

    }
}