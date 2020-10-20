//Q1.subsets
Solution : To generate all the subsets of the element in any given array, select an element and follow the path
and if in the path we find the set is already presnt in the output then remove 

Time complexity : exponential
Space : exponential


List<List<Integer>> output ;
public List<List<Integer>> subsets(int[] nums) {
  // Arrays.sort(nums);
  output = new ArrayList<>(); 
  helper(nums , new ArrayList<Integer>() , 0); 
  return output; 
    
}
private void helper(int[] nums, List<Integer> out,int index){
    output.add(new ArrayList(out));
    for(int i=index; i < nums.length; i++){
       int current = nums[i];
       out.add(current);
       //add element to the set
       helper(nums , out , i+1);
       //remove
       out.remove(out.size() -1);
        
    }
}
}




