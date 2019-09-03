class Solution:
	def subsets(self, nums):
		res = [[]]
		for i in nums:
			res += [j + [i] for j in res]
		return res

if __name__ == '__main__':
	ss = Solution()
	print(ss.subsets([8,4,1,2]))