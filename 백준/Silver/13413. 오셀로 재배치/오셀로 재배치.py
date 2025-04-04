T=int(input())
for _ in range(T):
  N=int(input())
  a=input()
  b=input()
  cnt=0
  wb=0
  bw=0
  for i in range(N):
    if a[i]=='W' and b[i]=='B':
      wb+=1
    if a[i]=='B' and b[i]=='W':
      bw+=1
  cnt=abs(wb-bw)+min(wb,bw)
  print(cnt)