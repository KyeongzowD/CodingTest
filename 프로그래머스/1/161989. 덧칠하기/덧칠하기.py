def solution(n, m, section):
    answer = 0
    d=1
    for x in section:
        if d>x:
            continue
        d=x+m
        answer+=1
    return answer