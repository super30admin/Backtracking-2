# time complexity and space complexity will be exponentiaal
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        def ispl(s):
            return s == s[::-1]
        
        n = len(s)
        res = []
        def helper(i,cur):
            if i == n:
                res.append(cur)
            for j in range(i+1,n+1):
                if  ispl(s[i:j]):
                    temp = cur + [s[i:j]]
                    helper(j,temp)
        
        helper(0,[])
        return res

    
# approch
#         a:
#             a:
#                 b:
#                     a:
#                         a: i == n-1 // add to res
#                 ba//
#                 baa:


#             ab//
#             aba:
#                 a:i == n -1 // add to res
#             abaa//
        
#         aa:
#             b:
                
#             ba//
#             baa

#         aab:
#             a
#             aa
        
#         aaba//
        
#         aabaa: i == n-1 
               