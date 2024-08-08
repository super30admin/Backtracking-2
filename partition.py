class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # If the input string is empty or None, return an empty list.
        if s == None or len(s) == 0:
            return []
        
        # Initialize the result list to store all possible palindrome partitions.
        self.result = []
        
        # Start the backtracking process from index 0 with an empty path.
        self.backtrack(s, 0, [])
        
        # Return the result containing all palindrome partitions.
        return self.result

    def backtrack(self, s: str, index: int, path: List[str]) -> None:
        # Base case: If we've reached the end of the string, add the current path to the result.
        if index == len(s):
            self.result.append(path[:])  # Append a copy of the current path.
            return
        
        # Logic: Explore all substrings starting from the current index.
        for i in range(index, len(s)):
            # Extract the substring from the current index to i+1.
            sub = s[index: i+1]
            
            # Check if the extracted substring is a palindrome.
            if self.isPalindrome(sub):
                # Action: Add the palindrome substring to the current path.
                path.append(sub)
                
                # Recur by moving to the next index after the current substring.
                self.backtrack(s, i + 1, path)
                
                # Backtrack: Remove the last substring from the path to explore other partitions.
                path.pop()

    def recurse(self, s: str, index: int, path: List[str]) -> None:
        # Base case: If we've reached the end of the string, add the current path to the result.
        if index == len(s):
            self.result.append(path)  # Append the current path.
            return
        
        # Logic: Explore all substrings starting from the current index.
        for i in range(index, len(s)):
            # Extract the substring from the current index to i+1.
            sub = s[index:i + 1]
            
            # Check if the extracted substring is a palindrome.
            if self.isPalindrome(sub):
                # Create a new list with the current path to avoid modifying the original.
                newList = [num for num in path]
                newList.append(sub)
                
                # Recur by moving to the next index after the current substring.
                self.recurse(s, i + 1, newList)

    def isPalindrome(self, s: str) -> bool:
        # Initialize two pointers for checking palindrome.
        left = 0
        right = len(s) - 1
        
        # Check if the string is a palindrome by comparing characters from both ends.
        while left <= right:
            if s[left] != s[right]:
                return False  # Not a palindrome if characters don't match.
            left += 1  # Move the left pointer to the right.
            right -= 1  # Move the right pointer to the left.
        
        return True  # Return True if the string is a palindrome.

        # return s == s[::-1]

        
