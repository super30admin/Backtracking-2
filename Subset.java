public class Subset {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result =  new ArrayList();
        helper( nums, new ArrayList(),0);
        result.add(new ArrayList());
        return result;
    }
    private void helper(int[] candidates, List<Integer> temp, int index){
        
        // base case
        
        if(  index >= candidates.length) {
            // System.out.println("hey"+sum);
            
            return;
        }
        
        result.add(temp);
        
        // logic
        
        //  if you don't choose move to the next element
        helper( candidates, new ArrayList(temp), index + 1);
        
        // System.out.println("index : "+index + " element "+ candidates[index]); 
        // if you choose
        temp.add(candidates[index]);
        
        helper(candidates, new ArrayList(temp), index+1);
    }
}