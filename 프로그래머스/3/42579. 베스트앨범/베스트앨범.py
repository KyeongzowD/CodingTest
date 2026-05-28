import operator
def solution(genres, plays):
    genre = {}
    song = {}
    for idx, (x, y) in enumerate(zip(genres, plays)):
        if x in genre:
            genre[x]+=y
        else: 
            genre[x]=y
            
        if x not in song:
            song[x] = [(idx, y)]
        else:
            song[x].append((idx, y))
            
    genre = sorted(genre.items(), key=operator.itemgetter(1), reverse=True)
    
    answer = []
    for k, v in genre:
        # song[k].sort(reverse=True)
        song[k].sort(key = lambda x: (-x[1], x[0]))
        sum =0
        for idx, _ in song[k][0:2]:
            answer.append(idx)
    return answer