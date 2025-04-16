N=int(input())
li=[]
for _ in range(N):
  li.append(input())

def func(s):
  res=0
  for c in s:
    if c.isnumeric():
      res+=int(c)
  return res

li.sort(key=lambda x: (len(x), func(x), x))
print('\n'.join(li))