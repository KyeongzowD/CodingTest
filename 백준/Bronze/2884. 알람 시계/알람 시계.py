h,m=input().split()
h=int(h)
m=int(m)
if m<45 :
    h-=1
    m=m+15
    if(h==-1):
        h=23
else :
    m-=45
print(h,m)