class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == nums || 0 == nums.length){
            return result;
        }
        result.add(new ArrayList<>());
        subsets(nums,0,new ArrayList<>(), result);
    return result;
    }
    private void subsets(int[] nums,int index, List<Integer> list, List<List<Integer>> result)     {
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);
            result.add(temp);
            subsets(nums,i+1,temp,result);
        }
    }
}