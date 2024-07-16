# Time Complexity : O(2^n)
# space complexity : O(n)

# Approach :

#   for loop based recursion
#   keep one recursive call
#   check if ispalindrome is true or false, if true continue for that character
#   keep a newlist which keeps getting new characters added
#   iterate from index to length of the string
#   append to final list when len of the string is eqaul to index

#   for loop based bactracking
#   keep one recursive call
#   check if ispalindrome is true or false, if true continue for that character
#   keep adding to the elements to path list array
#   iterate from index to length of the  string
#   keep popping the last element from the list
#   keep a copy of the list to be appended to the final array list, else it will be empty.
#   append to final list when len of the string is eqaul to index

class Solution:
    def partition(self, s: str) -> List[List[str]]:

        self.path = []
        self.recurse(s, 0, [])
        return self.path

    def recurse(self, strVal, index, path):

        if len(strVal) == index:
            self.path.append(path)
            return

        for i in range(index, len(strVal)):
            if (self.isPalindrome(strVal, index, i)):
                new_path = list(path)
                new_path.append(strVal[index:i+1])
                self.recurse(strVal, i+1, new_path)

    def isPalindrome(self, strVal, index, i):

        while index < i:
            if strVal[index] != strVal[i]:
                return False

            index += 1
            i -= 1

        return True


class Solution:
    def partition(self, s: str) -> List[List[str]]:

        self.path = []
        self.backtrack(s, 0, [])
        return self.path

    def backtrack(self, strVal, index, path):

        if len(strVal) == index:
            self.path.append(list(path))
            return

        for i in range(index, len(strVal)):
            if (self.isPalindrome(strVal, index, i)):
                path.append(strVal[index:i+1])
                self.backtrack(strVal, i+1, path)
                path.pop()

    def isPalindrome(self, strVal, index, i):

        while index < i:
            if strVal[index] != strVal[i]:
                return False

            index += 1
            i -= 1

        return True
