ISBN=list(input())
total=0
weight=0
for i,n in enumerate(ISBN):
  if n=='*':
    weight=3 if i%2 else 1
  elif i%2:
    total+=int(n)*3
  else:
    total+=int(n)
for i in range(10):
  if (total+weight*i)%10==0:
    print(i)