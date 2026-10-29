import sys
d=sys.stdin.read().split()
if not d:sys.exit(0)
p=0
n=int(d[p]);p+=1
s=[]
for _ in range(n):
    s.append([int(d[p+k]) for k in range(4)]);p+=4
x,y,e=int(d[p]),int(d[p+1]),int(d[p+2])
def on_s(i,px,py):
    x1,y1,x2,y2=s[i]
    if px<min(x1,x2) or px>max(x1,x2) or py<min(y1,y2) or py>max(y1,y2):return False
    return (px-x1)*(y2-y1)==(py-y1)*(x2-x1)
def cg(cx,cy,dx,dy):
    for i in range(n):
        if on_s(i,cx,cy) and on_s(i,cx+dx,cy+dy):return True
    return False
def sim():
    global x,y,e
    while True:
        b=-1
        for i in range(n):
            x1,y1,x2,y2=s[i]
            if x<min(x1,x2) or x>max(x1,x2):continue
            if x2==x1:continue
            h=y1+(y2-y1)//(x2-x1)*(x-x1)
            if h<y or (h==y and h>min(y1,y2)):
                if h>b:b=h
        if b<0:
            print(f"{x} 0",end='');return
        y=b
        while True:
            if y==0:
                print(f"{x} {y}",end='');return
            if cg(x,y,-1,1) and cg(x,y,1,1):
                c=x*y
                if e<c:
                    print(f"{x} {y}",end='');return
                e-=c
            d=0
            if cg(x,y,-1,-1):d=-1
            elif cg(x,y,1,-1):d=1
            if d==0:break
            if e<1:
                print(f"{x} {y}",end='');return
            e-=1
            x+=d;y-=1
sim()
