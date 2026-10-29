import sys
d=sys.stdin.read().split()
i=0
n=int(d[i]);i+=1
r=[]
for _ in range(n):
    r.append([int(d[i+k]) for k in range(4)]);i+=4
x1,y1,x2,y2=int(d[i]),int(d[i+1]),int(d[i+2]),int(d[i+3])
def mg(lo,hi,st,en):
    p=st;b=10**9
    for c in range(st+1,en+1):
        ok=True
        if c<en:
            for q in r:
                if q[lo]<c<q[hi]:ok=False;break
        if ok:b=min(b,c-p);p=c
    return b
w=mg(0,2,x1,x2)
h=mg(1,3,y1,y2)
print(w*h,end='')
