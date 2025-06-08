T=int(input())
for _ in range(T):
  N=int(input())
  D=dict()
  for _ in range(N):
    _,clothes=input().split()
    D[clothes]=D.get(clothes,0)+1
  A=list(D.values())
  res=1
  for i in A:
    res*=i+1
  # 알몸인 경우 제외
  print(res-1)