#Time Complexity - O(2^n)
#Space Complexity - O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def explore(string, arr):
            nonlocal result
            if string == "":
                result.append(arr.copy())
                return 
            for i in range(len(string)):
                if isPalindrome(string[0:i + 1]) == False:
                    continue 
                arr.append(string[0:i + 1])
                explore(string[i+1:len(string)],arr)
                arr.pop()

        def isPalindrome(string):
            l = 0
            r = len(string) - 1
            while l < r:
                if string[l] != string[r]:
                    return False
                l += 1
                r -= 1
            return True

        explore(s, [])
        return result

                