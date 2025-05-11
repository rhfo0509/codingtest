T=int(input())
def dfs(start, count, total):
  global result
  if count==N:
    if total==K:
      result+=1
    return
  for i in range(start,13):
    dfs(i+1,count+1,total+i)

for tc in range(1,T+1):
  N,K=map(int,input().split())
  result=0
  dfs(1, 0, 0)
  print(f'#{tc} {result}')