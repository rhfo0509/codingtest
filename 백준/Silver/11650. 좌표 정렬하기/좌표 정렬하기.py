N=int(input())
li=[]
for _ in range(N):
  li.append(tuple(map(int,input().split())))
li.sort(key=lambda x:(x[0],x[1]))
for pos in li:
  print(*pos)