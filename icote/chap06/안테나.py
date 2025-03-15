n = int(input())
h = list(map(int, input().split()))

h.sort()

# if len(h) % 2 == 1:
#   print(h[len(h) // 2])
# else:
#   l = h[len(h) // 2 - 1]
#   r = h[len(h) // 2]

#   l_sum = 0
#   r_sum = 0
#   for i in h:
#     l_sum += abs(l - i)
#     r_sum += abs(r - i)
#   print(l) if l_sum <= r_sum else print(r)

# 만약 집의 개수가 짝수라면, 중앙값이 두 개 존재하는데, 문제에서는 작은 쪽을 선택해야 하므로 (n-1)//2를 사용해 왼쪽 중앙값을 선택.
print(h[(n-1)//2])