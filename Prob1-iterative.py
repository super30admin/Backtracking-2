class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # Time complexity: O(n*2^n)
        #empty set to initiate size
        res = [[]]
        for num in nums:
            #when parsing through the numbers array, parse through
            #current result, for each element in current result
            #add current element in all result elements and add these to the result
            for i in xrange(len(res)):
                curEl = list(res[i])
                curEl.append(num)
                res.append(curEl)
        return res