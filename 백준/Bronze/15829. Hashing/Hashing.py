N = int(input())
s = input()

sum = 0
r = 31
M = 1_234_567_891
for i, c in enumerate(s):
  a = ord(c) - 96
  sum += a * (r ** i)
print(sum % M)