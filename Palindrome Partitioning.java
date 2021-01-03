/*
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if s is None or len(s) == 0:
            return []
        
        self.result = []
        self.backtrack(s, 0, [])
        return self.result
    
    def backtrack(self, s, index, temp):
        if index == len(s):
            self.result.append([]+temp)
            return
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                # action
                temp.append(s[index:i+1])
                #recurse
                self.backtrack(s, i+1, temp)
                # backtrack
                temp.pop()
    def isPalindrome(self, s, left, right):
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
*/

// Time Complexity : exponential
// Space Complexity : O(n) where n is s size 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I am considering one character then two uptil n characters and each time 
// recursing with the same for other characters
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(String s, int index, List<String> temp){
        if (index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<s.length(); i++){
            if (isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                backtrack(s, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}