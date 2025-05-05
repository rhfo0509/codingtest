cnt = 0
def n_queen(i):
  global cnt
  if i == N:
    cnt += 1
    return
  for j in range(N):
    if not col[j] and not diag1[i + j] and not diag2[i - j + N - 1]:
      col[j] = True
      diag1[i + j] = True
      diag2[i - j + N - 1] = True
      n_queen(i + 1)
      col[j] = False
      diag1[i + j] = False
      diag2[i - j + N - 1] = False
    
N = int(input())
result = []
# 해당 열에 퀸을 둘 수 있는지 여부
col = [False] * N
# 해당 대각선(╱)에 퀸을 둘 수 있는지 여부
diag1 = [False] * (2 * N - 1)
# 해당 대각선(╲)에 퀸을 둘 수 있는지 여부
diag2 = [False] * (2 * N - 1)
n_queen(0)
print(cnt)