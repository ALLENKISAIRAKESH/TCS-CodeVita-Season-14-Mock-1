import sys
d=sys.stdin.read().split()
if not d:sys.exit(0)
p=0
m,n=int(d[p]),int(d[p+1]);p+=2
ct=[0]*n
for i in range(m):
    for j in range(n):
        if d[p]=='*':ct[j]+=1
        p+=1
k=int(d[p]);p+=1
r,c=m,n
for _ in range(k):
    cmd=d[p];p+=1
    fq=[0]*(r+1)
    for v in ct:fq[v]+=1
    sf=[0]*(r+2)
    for v in range(r,0,-1):sf[v]=sf[v+1]+fq[v]
    if cmd.lower()=='right':
        ct=[sf[i+1] for i in range(r)]
    else:
        ct=[sf[r-i] for i in range(r)]
    r,c=c,r
out=[['.']*c for _ in range(r)]
for j in range(c):
    for i in range(r-ct[j],r):out[i][j]='*'
print('\n'.join(' '.join(row) for row in out),end='')
