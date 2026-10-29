import sys
d=sys.stdin.read().split()
if not d:sys.exit(0)
p=0
n=int(d[p]);p+=1
x=[0]*n;y=[0]*n
for i in range(n):
    x[i]=int(d[p])*10;y[i]=int(d[p+1])*10;p+=2
me=10**9
for i in range(n):
    j=(i+1)%n
    ln=abs(x[i]-x[j])+abs(y[i]-y[j])
    if 0<ln<me:me=ln
mx,my=max(x),max(y)
g=[[0]*(my+1) for _ in range(mx+1)]
for j in range(1,my+1):
    cy=j-0.5
    xs=[]
    for i in range(n):
        nxt=(i+1)%n
        if x[i]==x[nxt]:
            lo,hi=min(y[i],y[nxt]),max(y[i],y[nxt])
            if lo<cy<hi:xs.append(x[i])
    xs.sort()
    for idx_x in range(0,len(xs),2):
        for i in range(xs[idx_x]+1,xs[idx_x+1]+1):
            g[i][j]=1
pr=[[0]*(my+1) for _ in range(mx+1)]
for i in range(1,mx+1):
    pi,pim,gi=pr[i],pr[i-1],g[i]
    for j in range(1,my+1):
        pi[j]=pim[j]+pi[j-1]-pim[j-1]+gi[j]
bst=0.0
k=1
while me-2*k>=1 and 2*k+1<=min(mx,my):
    w=2*k+1
    ww=w*w
    cells=0
    for i in range(w,mx+1):
        r1,r2=pr[i],pr[i-w]
        for j in range(w,my+1):
            if r1[j]-r2[j]-r1[j-w]+r2[j-w]==ww:
                cells+=1
    vol=(cells/100.0)*(k/10.0)
    if vol>bst:bst=vol
    k+=1
print(f"{bst:.2f}",end='')
