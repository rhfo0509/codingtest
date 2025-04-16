import sys
input=sys.stdin.readline
N=int(input())
li=[]
for _ in range(N):
  li.append(int(input()))
li.sort()

max_cnt=0
res=li[0]
cnt=0
for i in range(N):
  cnt+=1
  if i!=N-1 and li[i]!=li[i+1]:
    if max_cnt<cnt:
      max_cnt=cnt
      res=li[i]
    cnt=0

if max_cnt<cnt:
  res=li[-1]
print(res)