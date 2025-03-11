s = input()

a = []
sum = 0

for i in s:
  # if ord('A') <= ord(i) <= ord('Z'):
  if i.isalpha():
    a.append(i)
  else:
    sum += int(i)


result = ''.join(sorted(a)) + str(sum)
print(result)