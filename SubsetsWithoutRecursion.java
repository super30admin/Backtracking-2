// Time Complexity : O(2*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class SubsetsWithoutRecursion {


    public List<List<Integer>> subsets(int[] nums) {


       List<List<Integer>> res = new ArrayList();
        if(nums==null || nums.length==0)
        {
            return res;
        }

        // add empty list in main res list
       res.add(new ArrayList<>());
       for(int num:nums)
       {
           int size = res.size();
           for(int i=0;i<size;i++)
           {
               List<Integer> temp = new ArrayList<>(res.get(i));
               temp.add(num);
               res.add(temp);


           }
       }


        return res;
    }




}