import math
def solution(progresses, speeds):
    count = []
    for i, j in zip(progresses, speeds):
        count.append(math.ceil((100-i)/j))
    
    answer = []
    cnt = 1
    v = count[0]
    for x in count[1:]:
        if v >= x:
            cnt+=1
        else:
            answer.append(cnt)
            v=x
            cnt=1
    
    answer.append(cnt)
    return answer