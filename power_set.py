class Solution(object):
    def subsets(self, nums):
        """
        Function to create a power set of distinct integers
  
        Approach :
      
        consider  a power_set([1,2,3]) -> [[1],[2],[3],[1,2],[2,3],[1,3], [1,2,3]]
                    power_set([1,2,3]) = power_set([1]) +  [s.add(1) for s in power_set([2,3])]  +  power_set(2,3])
      
        Time complexity :  O(2^n)
      
        Space complexity : O(n)
      
        Run on leet code : yes
        
        Edge Cases : []
      
      
        :type nums: List[int] integer set
        :rtype: List[List[int]] power set
        """
        return self._power_set(0, list(nums)) + [[]]  # added to cast set to list
    
    def _power_set(self, start, nums):
        """
        exit condition cases :

        _power_set(3,[1,2,3]) = []
        _power_set(2,[1,2,3]) = [3]


        :param start: index to start from
        :param nums: nums reference
        :return:
        """
        
        if (not nums) or (start == len(nums)):
            return []
        
        # add all elements in base list
        # add i to each element of power list
        
        x = self._power_set(start + 1, nums)
        y = [[nums[start]] + set_elem for set_elem in x]
        
        return x + y + [[nums[start]]]
