import sys
input = sys.stdin.readline

N = int(input())
scores = list(map(int, input().split()))

sum = 0
max = 0
for score in scores:
    sum += score
    if score>max:
        max=score

sum/=N

print(sum/max*100)
