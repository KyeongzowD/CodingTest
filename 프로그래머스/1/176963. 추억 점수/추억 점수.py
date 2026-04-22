def solution(name, yearning, photo):
    answer = []
    for name_list in photo:
        sum=0
        for n in name_list:
            if not n in name:
                continue
            idx=name.index(n)
            sum+=yearning[idx]
        answer.append(sum)
    return answer