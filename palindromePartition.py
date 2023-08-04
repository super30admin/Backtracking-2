#Time:O(n * 2^n)
#Space: O(n)
#issues faced: none
#did the code run successfully on LC?
#Approach:
#for all possible substrings starting with 1st letter,
#if it is a palindrome, then recurse on the remaining substring
#if the last index is reached, then it a valid palindrome partition.
#backtrack if the valid partition is found or it is not possible for the candidate solution.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def is_valid(str):
            i, j = 0, len(str)-1
            while i<=j:
                if str[i] != str[j]:
                    return 0
                i+=1;j-=1
            return 1

        def backtrack(s, candidate):
            for end in range(1, len(s)+1):
                substring = s[:end]
                if is_valid(substring):
                    candidate.append(substring) #place candidate
                    if end == len(s):
                        result.append(tuple(candidate))
                    else:
                        backtrack(s[end:], candidate) #explore
                    candidate.pop() #remove candidate
        backtrack(s, [])
        return result