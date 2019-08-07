//Iteratinve Solution
//Time Complexity : O(n*2^n)
//Space Complexity : O(2^n)

//Idea : 
// 1. Loop throup the numbers in the given array.
// 2. Find the subset of the numbers at current point . and add the  push the current element to all items in subset.
// 3. this forms new subset. again repeat the procedure untill all the items.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        result.add(new ArrayList<Integer>());  // pushing the empty list first.
        
        for(int i=0;i<nums.length;i++){
            
            int size = result.size(); // cal the size of the result list.
             
            for(int j=0;j<size;j++)
            {
              List<Integer> subset = new ArrayList<>(result.get(j));  //form the subset upto current element.
                
              subset.add(nums[i]); // push the current element to the subset each time 
              
              result.add(subset); // add it to main result set.
            }        
        
        }
        return result;
    }
}
