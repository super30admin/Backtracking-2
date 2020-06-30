/*
	Time complexity : 2^N
	worked on leetcode: YES


*/

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

/*

//recursive approach 
List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result =  new ArrayList();
        Backtrack( nums, new ArrayList(),0);
        // result.add(new ArrayList());
        return result;
    }
    private void Backtrack(int[] candidates, List<Integer> temp, int index){
        
       
        result.add(new ArrayList(temp));
        
        for(int i = index;i< candidates.length ;i++){
            // action
            temp.add(candidates[i]);
            // backtrack
            Backtrack(candidates, temp, i+1);
            // recurse
            temp.remove(temp.size()-1);
        }
    }

*/
