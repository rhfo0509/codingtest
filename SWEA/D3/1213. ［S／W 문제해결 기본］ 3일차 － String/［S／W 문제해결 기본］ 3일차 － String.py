T=10
for _ in range(T):
  N=int(input())
  word=input()
  s=input()
  cnt=0
  i=0
  while i<len(s):
    j=s.find(word,i)
    if j==-1:
      break
    cnt+=1
    i=j+1
  print(f'#{N} {cnt}')
