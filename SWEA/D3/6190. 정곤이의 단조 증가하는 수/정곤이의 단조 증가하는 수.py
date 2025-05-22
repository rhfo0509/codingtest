T=int(input())

def check(num):
  # 단조 증가 여부
  num=str(num)
  prev=num[0]
  for i in range(1,len(num)):
    if prev>num[i]:
      return False
    prev=num[i]
  return True

def dfs(start,arr):
  global result
  if len(arr)==2:
    num=arr[0]*arr[1]
    if check(num):
      result=max(result,num)
    return
  for i in range(start,N):
    dfs(i+1,arr+[A[i]])

for tc in range(1,T+1):
  N=int(input())
  A=list(map(int,input().split()))
  result=-1
  dfs(0,[])
  print(f'#{tc} {result}')
