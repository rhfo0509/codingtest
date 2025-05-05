cnt = 0
def func(i, s):
  global cnt
  if i == N:
    if s == S:
      cnt += 1
    return
  func(i + 1, s)
  func(i + 1, s + data[i])
    
N, S = map(int, input().split())
data = sorted(map(int, input().split()))
func(0, 0)
# S가 0인 경우, 공집합 제외
print(cnt - 1) if S == 0 else print(cnt)