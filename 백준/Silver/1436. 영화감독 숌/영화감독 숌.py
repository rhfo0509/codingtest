N=int(input())
cnt=0
cur=0
while True:
  if '666' in str(cur):
    cnt+=1
  if cnt==N:
    print(cur)
    break
  cur+=1