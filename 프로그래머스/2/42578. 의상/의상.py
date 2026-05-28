def solution(clothes):
    cloth_kind = list()
    cloth_size = list()
    
    for cloth in clothes:
        if cloth[1] in cloth_kind:
            idx = cloth_kind.index(cloth[1])
            cloth_size[idx] = cloth_size[idx]+1
        else:
            cloth_kind.append(cloth[1])
            cloth_size.append(1)
    
    sum = 1
    for x in cloth_size:
        sum*=x+1
        
    return sum -1