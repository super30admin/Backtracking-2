#Problem 2: Palindrome Partitioning
#Time Complexity: O(n2^n)
#Space Complexity: O(n)
'''
Instead of keeping track of the string, I can keep
track of where to split the string. Then I split it at the end when testing
for palindrome. We will do binary tree, split or not split to the end of the
array. Then we check if each element is a palindrome.
'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        split=[None]
        res=[]

        def helper(index):
            if index==len(s)-1:
                split.append(None)
                strings=[s[split[i]:split[i+1]] for i in range(len(split)-1)]
                split.pop()
                if all([valid(sub) for sub in strings]):
                    res.append(strings)
                return
            helper(index+1)
            split.append(index+1)
            helper(index+1)
            split.pop()
        
        def valid(sub):
            return (sub==sub[::-1])
        
        helper(0)
        return res
    
    
#Problem 2: Palindrome Partitioning
#Time Complexity: O(n2^n)
#Space Complexity: O(n)
'''
A better solution would be to check at every string if it's a palindrome
before continuing the recursion and the backtrack. On average it is WAY better
since as soon as there's one that is not a palindrome, we cut the branch entirely.
Although it doesn't change worse case complexity (for example "aaaaaaaaaaa"). I
coded a more intuitive recursion style for backtrack.
'''

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        memory=[]
        res=[]

        def helper(index):
            if index==len(s):
                res.append(memory[:])
                return
            for i in range(index+1,len(s)+1):
                #action
                if(s[index:i]==s[index:i][::-1]):
                    memory.append(s[index:i])
                    #recurse
                    helper(i)
                    #backtrack
                    memory.pop()
        helper(0)
        return res
