from collections import deque
T=int(input())
for _ in range(T):
  command=input()
  n=int(input())
  d=deque()
  na=input()
  if na!='[]':
    d=deque(map(int,na[1:-1].split(',')))
  flag='L'
  msg=''
  for c in command:
    if c=='R':
      if flag=='L':
        flag='R'
      else:
        flag='L'
    else:
      if len(d)==0:
        msg='error'
        break
      if flag=='L':
        d.popleft()
      else:
        d.pop()
  if msg!='error':
    if flag=='L':
      msg='['+','.join(map(str,list(d)))+']'
    else:
      msg='['+','.join(map(str,reversed(list(d))))+']'
  print(msg)
