M,N=map(int,input().split())
space=dict()
for _ in range(M):
  D=dict()
  li=list(map(int,input().split()))
  S=sorted(li)
  for i in range(N):
    D[S[i]]=i
  for i in range(N):
    li[i]=D.get(li[i])
  space[tuple(li)]=space.get(tuple(li),0)+1
cnt=0
for v in space.values():
  if v>=2:
    cnt+=v*(v-1)//2
print(cnt)