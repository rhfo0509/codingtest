N, K = map(int, input().split())
s = list(input())

cnt = 0
for i in range(len(s)):
  if s[i] == 'P':
    left = max(i - K, 0)
    right = min(i + K + 1, len(s))
    for j in range(left, right):
      if s[j] == 'H':
        s[j] = 'E'
        cnt += 1
        break
print(cnt)