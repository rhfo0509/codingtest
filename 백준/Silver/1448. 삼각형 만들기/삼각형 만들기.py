import sys
input = sys.stdin.readline

# 짧은 두 변의 길이의 합이 나머지 한 변의 길이보다 커야 한다.

N = int(input())

edges = []

for i in range(N):
  edges.append(int(input()))

edges.sort()

# 세 변의 길이의 합의 최댓값
result = -1

for i in range(N - 1, 1, -1):
  if edges[i] < edges[i - 1] + edges[i - 2]:
    result = sum(edges[i - 2 : i + 1])
    break

print(result)