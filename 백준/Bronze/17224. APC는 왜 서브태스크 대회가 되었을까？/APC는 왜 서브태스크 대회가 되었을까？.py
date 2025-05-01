N,L,K=map(int,input().split())
li=[tuple(map(int,input().split())) for _ in range(N)]
li.sort(key=lambda x: (x[1],x[0]))
cnt=0
score=0
s=set()
for i in range(N):
  if cnt==K:
    break
  if li[i][1]<=L:
    score+=140
    cnt+=1
    s.add(i)
for i in range(N):
  if cnt==K:
    break
  if i in s:
    continue
  if li[i][0]<=L:
    score+=100
    cnt+=1
print(score)