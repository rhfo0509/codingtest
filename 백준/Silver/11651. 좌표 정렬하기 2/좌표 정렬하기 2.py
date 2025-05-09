N=int(input())
li=[list(map(int,input().split())) for _ in range(N)]
li.sort(key=lambda x:(x[1],x[0]))
for pos in li:
  print(*pos)