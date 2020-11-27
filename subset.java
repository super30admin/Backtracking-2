


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  list= new ArrayList<>();
        List<Integer> sublist = new ArrayList<>(Collections.nCopies(nums.length, 0));
        helper(nums,0,list,sublist);
        return list ;
    }
    public void helper(int [] nums,int index,List<List<Integer>> list,List <Integer> sublist){
    if(index == nums.length )        
    {  
    List<Integer> newsublist = new ArrayList<>(sublist);
    newsublist.removeAll(Collections.singleton(null));
    list.add(new ArrayList(newsublist));
     return ;
   }
    sublist.set(index,null);
    helper(nums,index+1,list,sublist);
    sublist.set(index,nums[index]) ;
    helper(nums,index+1,list,sublist);
    }  

}
