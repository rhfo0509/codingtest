N=int(input())
drink=list(map(int,input().split()))
drink.sort()
M=drink.pop()
for i in drink:
  M += i/2
print(M)