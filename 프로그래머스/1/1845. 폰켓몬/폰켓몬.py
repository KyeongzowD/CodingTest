def solution(nums):
    count = set(nums)
    max = len(nums)/2
    l = len(count)
    if max>l:
        return l
    return max