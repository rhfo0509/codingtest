s=input()
stk=[]
cnt=0
i=0
while i<len(s):
  if s[i]=='(' and s[i+1]==')':
    cnt+=len(stk)
    i+=2
    continue
  else:
    if s[i]=='(':
      stk.append(s[i])
    else:
      stk.pop()
      cnt+=1
  i+=1
print(cnt)