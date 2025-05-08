T=10
for tc in range(1,T+1):
  N=int(input())
  data=[list(input()) for _ in range(8)]
  cnt=0
  # 오른쪽 방향으로 탐색
  for i in range(8):
    for j in range(9-N):
      # 팰린드롬 여부
      flag=True
      s=data[i][j:j+N]
      start=0
      end=N-1
      while start<end:
        if s[start]!=s[end]:
          flag=False
          break
        start+=1
        end-=1
      if flag==True:
        cnt+=1
  # 아래쪽 방향으로 탐색
  for i in range(8):
    for j in range(9-N):
      # 팰린드롬 여부
      flag=True
      s=''
      for k in range(j, j+N):
        s+=data[k][i]
      start=0
      end=N-1
      while start<end:
        if s[start]!=s[end]:
          flag=False
          break
        start+=1
        end-=1
      if flag==True:
        cnt+=1
  
  print(f'#{tc} {cnt}')