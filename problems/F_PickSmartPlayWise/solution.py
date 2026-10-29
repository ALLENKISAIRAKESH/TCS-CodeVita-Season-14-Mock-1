import sys,math
from collections import deque
d=sys.stdin.read().split()
if not d:sys.exit(0)
p=0
n=int(d[p]);p+=1
s=[]
for _ in range(n):
    s.append([float(d[p+k]) for k in range(4)]);p+=4
pt=[];mp={}
def get_id(x,y):
    k=f"{round(x*1e6)},{round(y*1e6)}"
    if k not in mp:
        mp[k]=len(pt);pt.append((x,y))
    return mp[k]
on=[[] for _ in range(n)]
tot=0
for i in range(n):
    tot+=math.hypot(s[i][2]-s[i][0],s[i][3]-s[i][1])
    on[i].append((0.0,get_id(s[i][0],s[i][1])))
    on[i].append((1.0,get_id(s[i][2],s[i][3])))
for i in range(n):
    for j in range(i+1,n):
        rx,ry=s[i][2]-s[i][0],s[i][3]-s[i][1]
        qx,qy=s[j][2]-s[j][0],s[j][3]-s[j][1]
        dt=rx*qy-ry*qx
        if abs(dt)<1e-12:continue
        wx,wy=s[j][0]-s[i][0],s[j][1]-s[i][1]
        t=(wx*qy-wy*qx)/dt
        u=(wx*ry-wy*rx)/dt
        if -1e-9<=t<=1+1e-9 and -1e-9<=u<=1+1e-9:
            px,py=s[i][0]+t*rx,s[i][1]+t*ry
            idx=get_id(px,py)
            on[i].append((t,idx));on[j].append((u,idx))
m=len(pt)
g=[set() for _ in range(m)]
for i in range(n):
    on[i].sort(key=lambda x:x[0])
    for k in range(len(on[i])-1):
        u,v=int(on[i][k][1]),int(on[i][k+1][1])
        if u!=v:g[u].add(v);g[v].add(u)
q=deque(i for i in range(m) if len(g[i])<=1)
while q:
    u=q.popleft()
    for v in list(g[u]):
        g[v].discard(u)
        if len(g[v])==1:q.append(v)
    g[u].clear()
st=next((i for i in range(m) if len(g[i])>=2),-1)
if st==-1:
    print("Abandoned",end='')
else:
    ar,pr2=0.0,0.0
    prv,cur=-1,st
    while True:
        nxt=next(v for v in g[cur] if v!=prv)
        x1,y1=pt[cur];x2,y2=pt[nxt]
        ar+=x1*y2-y1*x2
        pr2+=math.hypot(x2-x1,y2-y1)
        prv,cur=cur,nxt
        if cur==st:break
    ar=abs(ar)/2.0
    lft=tot-pr2
    cp=lft*lft/(4.0*math.pi)
    if cp>ar:print("Computer",end='')
    else:print("Kalyan",end='')
