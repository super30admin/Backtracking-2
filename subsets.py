# Time cmplexity will be 2^n (Exponantial)
# space complexity will be 2^n (Exponantial)

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = [[]]
        for i in nums:
            temp = []
            for r in res:
                temp.append(r + [i])
            res = res + temp
        return res
    
    
# approch 
# considering each possible combination without repetation
# intution: 
#     looking the pattern 
#     []:
#         [] + [1] = [1]
    
#     [][1]:
#         [] + [2] = [2]
#         [1] + [2] = [1,2]
    
#     [][1][2][1,2]:
#         [] + [3] = [3]
#         [1] + [3] = [1,3]
#         [2] + [3] = [2,3]
#         [1,2] + [3] = [1,2,3]
    
#     [][1][2][1,2][3][1,3],[2,3],[1,2,3]
    
    
# so,
# for each elemnt in nums:
#     res = res + [i]
# return res

    