class Problem78 {
    //Time complexity o(2^n) 
    //Space complexity o(n)
    List<List<Integer>> finalSet;
    public List<List<Integer>> subsets(int[] nums) {
        finalSet=new ArrayList<>();
        helper(nums,0, new ArrayList<>());
        return finalSet;
    }
    private void helper(int[] nums, int pivot, List<Integer> subSet){
        //base case
       /* if(pivot>nums.length)
            return;*/
        //no base case as we need to all add combination in the finalset and pivot will never exceed nums.length as we are calling it from for loop
        
        finalSet.add(new ArrayList<>(subSet));
        //main logic
        for(int i=pivot;i<nums.length;i++){
            subSet.add(nums[i]);
            helper(nums,i+1,subSet);
            subSet.remove(subSet.size()-1);
        }
    }
    public static void main(String[] args) {
        Problem78 problem=new Problem78();
        System.out.println(problem.subsets(new int[]{1,2,3}));
    }

}
