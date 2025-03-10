n, m = map(int, input().split())
s = [] # 각 행에서 가장 낮은 숫자

while n > 0:
  r = list(map(int, input().split()))
  s.append(min(r))
  n -= 1

print(max(s))