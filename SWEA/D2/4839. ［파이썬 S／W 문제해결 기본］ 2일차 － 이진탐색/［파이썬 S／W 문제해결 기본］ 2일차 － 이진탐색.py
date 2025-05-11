T=int(input())
for tc in range(1,T+1):
  P,A,B=map(int,input().split())
  la,ra=1,P
  lb,rb=1,P
  winner=0
  while True:
    ca=(la+ra)//2
    cb=(lb+rb)//2
    if ca==A and cb==B:
      break
    if ca==A:
      winner='A'
      break
    if cb==B:
      winner='B'
      break

    if A<ca:
      ra=ca
    else:
      la=ca
    if B<cb:
      rb=cb
    else:
      lb=cb
  print(f'#{tc} {winner}')
