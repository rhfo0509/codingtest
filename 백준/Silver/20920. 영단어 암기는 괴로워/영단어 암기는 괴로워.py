N,M=map(int, input().split())
D=dict()
for _ in range(N):
  s=input()
  if len(s) < M:
    continue
  if D.get(s):
    D[s] += 1
  else:
    D[s] = 1
res=sorted(D.keys(), key=lambda x: (-D[x], -(len(x)), x))
print('\n'.join(res))