s = input()

is_palindrome = 1
for i in range(len(s)//2):
  if s[i] != s[-(i+1)]:
    is_palindrome = 0
    break
print(is_palindrome)