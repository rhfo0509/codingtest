import sys
input=sys.stdin.readline
n=int(input())
data=[]
for _ in range(n):
  data.append(int(input()))
stk=[]
i=1
res=[]
flag=True
for num in data:
  while i<=num:
    stk.append(i)
    res.append('+')
    i+=1
  if i>num:
    if stk.pop()!=num:
      flag=False
      break
    res.append('-')

print('NO') if not flag else print('\n'.join(res))