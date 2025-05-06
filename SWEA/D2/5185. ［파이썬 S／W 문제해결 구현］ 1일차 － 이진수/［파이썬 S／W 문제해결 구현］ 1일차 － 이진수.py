T = int(input())
for i in range(T):
  N, hex = input().split()
  result = ''
  for digit in hex:
    digit = int(digit, 16)
    divisors = [8, 4, 2, 1]
    for divisor in divisors:
      result += str(digit // divisor)
      digit %= divisor
  print(f'#{i + 1} {result}')