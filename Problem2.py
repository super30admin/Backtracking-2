#In this code, I implemented a solution to partition a string s into all possible palindromic substrings. I created a method partition that initializes an empty list to store the partitions and calls a helper function partitionUtil. This helper function recursively explores all possible partitions of the string starting from index i. If the index reaches the end of the string, the current partition path is added to the result list. For each index i, the helper function checks substrings starting from i to j using the isPalindrome method, which verifies if a substring is a palindrome. If it is, the substring is added to the current path, and the function recursively continues to partition the remaining substring. After exploring a path, the substring is removed (backtracking) to explore other partitions. The time complexity is O(n⋅2^n) due to the exponential number of possible partitions and the linear time to check each partition, and the space complexity is O(n) for the recursive call stack and storing the partitions.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.partitions = []
        path = []
        self.partitionUtil(s, 0, path)
        return self.partitions 

    def partitionUtil(self, s, i, path) :
        if i == len(s) :
            self.partitions.append(tuple(path))
        
        j = i 
        while j < len(s) :
            if self.isPalindrome(s[i : j + 1 ]) :
                path.append(s[i : j + 1 ])
                self.partitionUtil(s, j+1, path)
                path.pop()
            
            j += 1

    def isPalindrome(self, a) :
        i, j = 0, len(a) -1 
        while i < j :
            if a[i] != a[j] :
                return False

            i += 1
            j -= 1

        return True 