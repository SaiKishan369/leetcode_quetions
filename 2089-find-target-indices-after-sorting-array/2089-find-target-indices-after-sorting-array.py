class Solution(object):
    def targetIndices(self, nums, target):
        nums.sort()
        result = []

        for i, num in enumerate(nums):
            if num == target:
                result.append(i)

        return result