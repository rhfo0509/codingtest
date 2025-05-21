T=int(input())
for tc in range(1,T+1):
  L,U,X=map(int,input().split())
  print(f'#{tc}',end=' ')
  if L>X:
    print(L-X)
  elif L<=X<=U:
    print(0)
  else:
    print(-1)