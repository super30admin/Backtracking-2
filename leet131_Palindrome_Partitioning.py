
# Solution
# Complexity is same for both approaches
# One important thing when using pivot and index in "for loop based recursion" and "normal recursion" is, when we are using
# "for loop based recursion" we can see that we recurse on "choose" scenario only and we do that only if the substring is palindrome,
# where the for loop keeps going, which acts like the "no choose" scenario continuing even when substring is not palindrome.
# So when we convert this to normal recursion, we need to make sure the "choose" scenario only triggers when substring is palindrome
# and "no choose" recursion triggers all the time
# // Time Complexity : For loop based recursion O(n*(2^n)), since we follow choose,nochoose approach, so it becomes binary tree,
#                      for each element there will be two options, so we will end up with 2^n routes/solutions. For each we also
#                      need to check if the split string is palindrome, worst case that would be O(N). So in total n*(2^n)
# // Space Complexity : For loop based recursion O(N) since the max implicit stack size will be N
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None

# // Your code here along with comments explaining your approach
# Approach is to use the split(choose)/dont split(no choose) option to check what strings we would get if we split at a particular
# string and if we do not split at a particular string. Solution will be a binary tree again with 2^n outcomes and max height
# of N

# S30 normal recursion
def partition(s):
    def isPalindrome(str):
        i = 0
        j = len(str)-1
        while i<=j:
            if str[i] != str[j]:
                return False
            else:
                i += 1
                j -= 1
        return True

    def helper(s,pivot,idx,path,result):
        if idx>=len(s) or pivot>=len(s):
            if len("".join(path)) == len(s):
                result.append(path.copy())
            return

        temp = ""
        for j in range(pivot,idx+1):
            temp += s[j]
        
        if isPalindrome(temp):
            path.append(temp)
            helper(s,idx+1,idx+1,path,result)
            path.pop()
        helper(s,pivot,idx+1,path,result)
    
    result = []
    helper(s,0,0,[],result)
    return result

# S30 For loop based recursion
# def partition(s):
#     def isPalindrome(str):
#         i = 0
#         j = len(str)-1
#         while i<=j:
#             if str[i] != str[j]:
#                 return False
#             else:
#                 i += 1
#                 j -= 1
#         return True

#     def helper(s,pivot,path,result):
#         if pivot>=len(s):
#             result.append(path.copy())
#             return
        
#         for i in range(pivot,len(s)):
#             temp = ""
#             for j in range(pivot,i+1):
#                 temp += s[j]

#             if isPalindrome(temp):
#                 path.append(temp)
#                 helper(s,i+1,path,result)
#                 path.pop()

#     result = []
#     helper(s,0,[],result)
#     return result

if __name__ =="__main__":
    s = "aab"
    print(partition(s))