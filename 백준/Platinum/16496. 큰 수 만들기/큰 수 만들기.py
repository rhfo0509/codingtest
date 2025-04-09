N = int(input())
A = list(input().split())
li=[]
for n in A:
  li.append(n)
for i in range(len(li)):
  for j in range(len(li)):
    if i<j and li[i]+li[j]<li[j]+li[i]:
      li[i], li[j] = li[j], li[i]

if li.count('0')==len(li):
  print(0)
else:
  print(''.join(li))