N, K = map(int, input().split())
# na = list(map(int, input()))
# while K > 0:
#   for i in range(1, len(na)):
#     if na[i - 1] < na[i]:
#       na.remove(na[i - 1])
#       K -= 1
#       break
# print(''.join(map(str, na)))
s = input()
stk = []

for i in s:
  while stk and K > 0 and stk[-1] < i:
    stk.pop()
    K -= 1
  stk.append(i)

print(''.join(stk[:len(stk)-K]))