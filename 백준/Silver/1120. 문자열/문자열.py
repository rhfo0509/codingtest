A, B = input().split()
diff = len(B) - len(A)
min_cnt = len(A)

for i in range(diff + 1):
  cnt = 0
  S = "*" * i + A + "*" * (diff - i)
  for j in range(len(B)):
    if S[j] != "*" and S[j] != B[j]:
      cnt += 1
  if cnt < min_cnt:
    min_cnt = cnt
print(min_cnt)