N=int(input())
li=[]
for i in range(N):
  li.append(input().split()+[i])
li.sort(key=lambda x:(int(x[0]),x[2]))
for d in li:
  print(d[0], d[1])