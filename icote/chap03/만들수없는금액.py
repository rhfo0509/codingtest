# import copy

n = int(input())

unit = list(map(int, input().split()))
unit.sort()

# res = sum(unit) + 1
# s = set()

# for i in unit:
#   if res < i:
#     break
#   if len(s) == 0: 
#     s.add(i)
#     res = i + 1
#     continue
#   else:
#     tmp = copy.deepcopy(s)
#     for j in s:
#       tmp.add(i + j)
#     s = tmp
#     res = max(s) + 1

res = 1  # 만들 수 없는 최소 금액

for i in unit:
    if res < i:
        break
    res += i


print(res)
