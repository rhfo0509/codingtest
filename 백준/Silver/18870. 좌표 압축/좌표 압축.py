N=int(input())
X=list(map(int, input().split()))
S=list(set(X))
S.sort()
D=dict()
for i,s in enumerate(S):
  D[s]=i
for x in X:
  print(D[x], end=' ')