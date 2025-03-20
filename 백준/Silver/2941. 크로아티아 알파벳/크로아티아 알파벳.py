s = input()

alphabet = ('c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=')

cnt = 0
for i in alphabet:
  a = s.split(i)
  cnt += len(a) - 1
  s = ' '.join(a)

for i in s:
  if i.isalpha():
    cnt += 1
print(cnt)