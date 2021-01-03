/*
# Normal recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0:
            return []
        
        self.result = []
        self.helper(nums, [], 0)
        
        return self.result
    
    def helper(self,nums, temp, index):
        if index == len(nums):
            self.result.append(temp)
            return
        
        # dont choose
        self.helper(nums, []+temp, index+1)
        
        # choose
        temp.append(nums[index])
        self.helper(nums, []+temp, index+1)


# Normal recursion with for template
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0:
            return []
        
        self.result = []
        self.helper(nums, [], 0)
        
        return self.result
    
    def helper(self,nums, temp, index):
        self.result.append(temp)
        
        
        for i in range(index, len(nums)):
            temp2 = []+temp
            temp2.append(nums[i])
            self.helper(nums, temp2, i+1)



# backtracking with first template
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0:
            return []
        
        self.result = []
        self.helper(nums, [], 0)
        
        return self.result
    
    def helper(self,nums, temp, index):
        if index == len(nums):
            self.result.append([]+temp)
            return
        
        # dont choose
        self.helper(nums, temp, index+1)
        
        # choose
        temp.append(nums[index])
        self.helper(nums, temp, index+1)
        temp.pop()

# backtracking with for template
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0:
            return []
        
        self.result = []
        self.helper(nums, [], 0)
        
        return self.result
    
    def helper(self,nums, temp, index):
        self.result.append([]+temp)
        
        
        for i in range(index, len(nums)):
            temp.append(nums[i])
            self.helper(nums, temp, i+1)
            temp.pop()

*/

/*
// Normal recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        
        helper(nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index){
        if (index == nums.length){
            result.add(temp);
            return;
        }
            
        
        // dont choose
        helper(nums, new ArrayList<>(temp), index+1);
        
        // choose
        temp.add(nums[index]);
        helper(nums, new ArrayList<>(temp), index+1);
    }
}

// Normal recursion with for template
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        
        helper(nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index){
        result.add(temp);
        
        for (int i=index; i<nums.length; i++){
            List<Integer> temp2 = new ArrayList<>(temp);
            temp2.add(nums[i]);
            
            helper(nums, temp2, i+1);
        }
    }
}


// backtracking with first template
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        
        helper(nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index){
        if (index == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
            
        
        // dont choose
        helper(nums, temp, index+1);
        
        // choose
        temp.add(nums[index]);
        helper(nums, temp, index+1);
        temp.remove(temp.size()-1);
    }
}
*/
// Time Complexity : O(2^n) where n is size of nums
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: the for loop with consider all the possible combinations and 
// i am backtracking as well 


// backtracking with for template
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        
        helper(nums, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index){
        result.add(new ArrayList<>(temp));
        
        for (int i=index; i<nums.length; i++){
            temp.add(nums[i]);
            
            helper(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}