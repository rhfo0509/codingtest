T=int(input())
for tc in range(1,T+1):
  result=set()
  N,K=map(int,input().split())
  digit=N//4
  data=input()
  # 0회전
  for i in range(4):
    result.add(int(data[i*digit:i*digit+digit], 16))
  # n회전
  for _ in range(digit):
    data=data[-1]+data[:-1]
    for i in range(4):
      result.add(int(data[i*digit:i*digit+digit], 16))
  result=sorted(list(result),reverse=True)[K-1]
  print(f'#{tc} {result}')