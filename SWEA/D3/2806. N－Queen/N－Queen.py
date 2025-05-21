T=int(input())
def n_queen(i,arr):
  global result
  if i==N:
    result+=1
    return
  for j in range(N):
    flag=True
    for x,y in arr:
      if y==j or y-x==j-i or x+y==i+j:
        flag=False
        break
    if flag:
      n_queen(i+1,arr+[(i,j)])


for tc in range(1,T+1):
  N=int(input())
  result=0
  n_queen(0,[])
  print(f'#{tc} {result}')
