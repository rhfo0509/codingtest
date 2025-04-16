N=int(input())
A=list(map(int,input().split()))
B=[]
res=[]
for num in A[::-1]:
  while B and B[-1]<=num:
    B.pop()
  res.append(-1) if not B else res.append(B[-1])
  B.append(num)
print(*res[::-1])