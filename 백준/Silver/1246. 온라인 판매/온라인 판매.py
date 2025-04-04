N,M=map(int,input().split())
li=[]
for i in range(M):
  li.append(int(input()))
li.sort(reverse=True)
price=0
gain=0
for i in range(M):
  if gain<li[i]*(i+1):
    gain=li[i]*(i+1)
    price=li[i]
  N-=1
  if N==0:
    break
print(price,gain)