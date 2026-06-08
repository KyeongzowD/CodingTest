def solution(arr):
    answer = [arr[0]]
    idx = 0
    for i, x in enumerate(arr):
        if arr[idx]!=x:
            answer.append(x)
        idx=i
    return answer