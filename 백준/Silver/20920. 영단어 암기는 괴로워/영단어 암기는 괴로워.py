from collections import Counter
N,M=map(int, input().split())
A=[]
for _ in range(N):
  s=input()
  if len(s) >= M:
    A.append(s)
C = Counter(A)
res=sorted(C.keys(), key=lambda x: (-C[x], -(len(x)), x))
print('\n'.join(res))