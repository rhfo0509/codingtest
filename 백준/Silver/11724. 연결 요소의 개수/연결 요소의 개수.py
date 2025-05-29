import sys
input = sys.stdin.readline
N, M = map(int, input().split())
parent = [i for i in range(N + 1)]
def find(x):
  if x != parent[x]:
    parent[x] = find(parent[x])
  return parent[x]
def union(a, b):
  a = find(a)
  b = find(b)
  if a != b:
    if a < b: parent[b] = a
    else: parent[a] = b
for _ in range(M):
  u, v = map(int, input().split())
  union(u, v)
for i in range(1, N + 1):
  find(i)
print(len(set(parent[1:])))