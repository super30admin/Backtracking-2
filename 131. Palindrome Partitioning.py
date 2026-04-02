# Time: O(n * 2^n) where n is the length of the input string s. This is because we are generating all possible partitions of the string, which can be at most 2^(n-1) i.e 2 choices at each point so (2^n) (since we can partition between any two characters). For each partition, we are checking if it is a palindrome, which takes O(n) time in the worst case.
# Space: O(n) because we are using a path list to store the current partition, which can at most contain n elements (in the case where each character is a palindrome). Additionally, we are using a result list to store all the partitions, which can also contain at most 2^(n-1) partitions in the worst case. However, since we are only storing the partitions and not the individual characters, the space complexity is O(n) for the path list and O(2^n) for the result list, but we typically consider the space complexity in terms of the input size, so it is O(n).

# Question => Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

# The way we do it is by taking a continuous string between pivot and the index i, Then check if the current string that is choosen is a palindrome, if it is not we don't need to go forward as the question asks for all partitions to be palindrome.
# If the string choosen is a palindrome then add it to the path and then call the helper function recursively with the new pivot as i + 1, this is because we want to start from the next index after the current string. 
# After the recursive call we need to backtrack by removing the last element from the path list, this is because we want to explore other partitions that may be possible with the current pivot.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result
    def helper(self, s, pivot, path):
        def is_palindrome(s, start, end):
            if s == s[:: -1]:
                return True
            return False
        # Base case
        if pivot == len(s):
            self.result.append(list(path))

        # Logic
        for i in range(pivot, len(s)):
            curr_path = s[pivot: i + 1: 1]
            if is_palindrome(curr_path, 0, len(curr_path)):
                # Action
                path.append(curr_path)
                # Recurse
                self.helper(s, i + 1, path)
                # Backtrack
                path.pop()