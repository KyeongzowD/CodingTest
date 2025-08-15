X=input()
X=int(X)
N=input()
N=int(N)
for n in range (N):
    a,b=input().split()
    a=int(a)
    b=int(b)
    X-=(a*b)
if X==0:
    print('Yes')
else:
    print('No')