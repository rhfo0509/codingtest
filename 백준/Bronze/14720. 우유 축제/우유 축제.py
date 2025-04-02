N=int(input())
store=list(map(int,input().split()))
flag=0
cnt=0
for milk in store:
  if milk==flag:
    flag=(flag+1)%3
    cnt+=1
print(cnt)