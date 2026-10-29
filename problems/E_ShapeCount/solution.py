import sys
d=sys.stdin.read().split()
if not d:sys.exit(0)
p=0
n=int(d[p]);p+=1
s=[]
for _ in range(n):
    a,b,c,e=int(d[p]),int(d[p+1]),int(d[p+2]),int(d[p+3]);p+=4
    s.append((min(a,c),min(b,e),max(a,c),max(b,e)))
xs=sorted(set(v for q in s for v in (q[0],q[2])))
ys=sorted(set(v for q in s for v in (q[1],q[3])))
xi={v:i for i,v in enumerate(xs)}
yi={v:i for i,v in enumerate(ys)}
w,h=len(xs),len(ys)
hm=[0]*h
vm=[0]*(h-1)
for q in s:
    xa,ya,xb,yb=xi[q[0]],yi[q[1]],xi[q[2]],yi[q[3]]
    if q[1]==q[3]:
        for k in range(xa,xb):hm[ya]|=(1<<k)
    elif q[0]==q[2]:
        for k in range(ya,yb):vm[k]|=(1<<xa)
ans=0
for a in range(h):
    if not hm[a]:continue
    ma=hm[a]
    cv=(1<<w)-1
    for b in range(a+1,h):
        cv&=vm[b-1]
        if not cv:break
        cm=ma&hm[b]
        if not cm:continue
        while cm:
            st=(cm&-cm).bit_length()-1
            tp=cm>>st
            ln=(~tp&(tp+1)).bit_length()-1
            cm&=~(((1<<ln)-1)<<st)
            m=bin((cv>>st)&((1<<(ln+1))-1)).count('1')
            ans+=m*(m-1)//2
print(ans,end='')
