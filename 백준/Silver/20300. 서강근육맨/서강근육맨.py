N = int(input())
T = list(map(int, input().split()))
T.sort()

M = T.pop() if N % 2 == 1 else 0
for i in range(len(T) // 2):
  M = max(M, T[i] + T[len(T) - 1 - i])
print(M)