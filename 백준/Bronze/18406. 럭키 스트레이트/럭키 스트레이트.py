n = list(input())

l_sum = 0
for i in range(len(n)//2):
  l_sum += int(n[i])

r_sum = 0
for j in range(len(n)//2, len(n)):
  r_sum += int(n[j])

print('LUCKY') if l_sum == r_sum else print('READY')