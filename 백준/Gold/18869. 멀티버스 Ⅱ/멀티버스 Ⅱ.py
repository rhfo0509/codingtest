import bisect
M,N=map(int,input().split())
space=dict()
for _ in range(M):
  li=list(map(int,input().split()))
  s=sorted(li)
  for i in range(N):
    # lower_bound
    li[i]=bisect.bisect_left(s,li[i])
  space[tuple(li)]=space.get(tuple(li),0)+1
cnt=0
for v in space.values():
  if v>=2:
    cnt+=v*(v-1)//2
print(cnt)