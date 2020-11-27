class Solution:
	# Time complexity : exponential, O(2^n)
	def subsets1(self, nums):
		res = [[]]
		for i in nums:
			res += [j + [i] for j in res]
		return res

	def subsets2(self, nums):
		res = []
		if len(nums) == 0:
			return res
		temp = []
		self.helper(nums, temp, res, 0)
		return res

	def helper(self, nums, temp, res, start):
		res.append(temp[:])
		for i in range(start, len(nums)):
			temp.append(nums[i])
			self.helper(nums, temp, res, i + 1)
			temp.pop()

if __name__ == '__main__':
	ss = Solution()
	print(ss.subsets1([8,4,1,2]))
	print(ss.subsets2([8,4,1,2]))