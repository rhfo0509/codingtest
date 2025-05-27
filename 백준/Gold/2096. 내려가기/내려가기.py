N = int(input())
a, b, c = map(int, input().split())
mx_dp = [a, b, c]
mn_dp = [a, b, c]
for i in range(1, N):
  a, b, c = map(int, input().split())
  mx_a = max(mx_dp[0], mx_dp[1]) + a
  mn_a = min(mn_dp[0], mn_dp[1]) + a
  mx_b = max(mx_dp) + b
  mn_b = min(mn_dp) + b
  mx_c = max(mx_dp[1], mx_dp[2]) + c
  mn_c = min(mn_dp[1], mn_dp[2]) + c

  mx_dp = [mx_a, mx_b, mx_c]
  mn_dp = [mn_a, mn_b, mn_c]
print(max(mx_dp), min(mn_dp))
