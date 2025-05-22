T=int(input())
for tc in range(1,T+1):
  N,M=map(int,input().split())
  res=format(M,"030b")[30-N:]

  print(f'#{tc}',end=' ')
  if len(set(res))==1 and set(res).pop()=='1':
    print('ON')
  else:
    print('OFF')
