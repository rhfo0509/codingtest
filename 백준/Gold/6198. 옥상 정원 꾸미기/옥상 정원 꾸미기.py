import sys
input=sys.stdin.readline
N=int(input())
res=0

li=[]
for _ in range(N):
  li.append(int(input()))
buildings=[]

for i,h in enumerate(li):
  while buildings and buildings[-1]<=h:
    buildings.pop()

  res+=len(buildings)
  buildings.append(h)
print(res)