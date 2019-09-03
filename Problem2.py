class Solution:
	# Time Complexity : Exponential
	def partition(self, s: str) -> List[List[str]]:
		res = []
		if len(s) == 0:
			return res
		temp = []
		self.helper(s, res, temp, 0)
		return res

	def helper(self, s, res, temp, pos):
		# base case
		if pos >= len(s):
			res.append(temp[:])
		for i in range(pos, len(s)):
			if self.ispalindrome(s[pos:i + 1]):
				temp.append(s[pos:i + 1])
				self.helper(s, res, temp, i + 1)
				temp.pop()
	
	def ispalindrome(self, s):
		return s == s[::-1]