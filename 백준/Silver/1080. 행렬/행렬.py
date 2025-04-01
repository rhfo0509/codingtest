N,M=map(int, input().split())
A=[]
B=[]

for _ in range(N):
  A.append(list(map(int, input())))
for _ in range(N):
  B.append(list(map(int, input())))

cnt=0
for i in range(N-2):
  for j in range(M-2):
    if A[i][j]!=B[i][j]:
      cnt+=1
      for x in range(3):
        for y in range(3):
          A[i+x][j+y] = int(not A[i+x][j+y])

for i in range(N):
  for j in range(M):
    if A[i][j]!=B[i][j]:
      print(-1)
      exit()
print(cnt)