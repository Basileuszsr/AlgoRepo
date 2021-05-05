class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        #异常处理
        if not nums:
            return []
        
        #答案集建立和排序
        result = []
        nums.sort()

        #3sum 实质就是一个for循环的遍历 + 2sum。把a + b + c = 0 看成 a + b= -c，for循环-c套一个a + b的2sum。
        for a in range(0, len(nums) - 2):
            left, right = a + 1, len(nums) - 1
            while left < right: 
                if nums[left] + nums[right] == -nums[a]:
                    #去重
                    if [nums[a], nums[left], nums[right]] not in result:
                        result.append([nums[a], nums[left], nums[right]])
                    left += 1
                    right -= 1
                elif nums[left] + nums[right] < -nums[a]:
                    left += 1
                else:
                    right -= 1 
        
        return result
