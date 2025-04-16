s=input()
stk=[]
flag=True
for c in s:
  # 여는 괄호인 경우 스택에 추가
  if c=='(' or c=='[':
    stk.append(c)
  
  # 그 이외의 경우 (숫자, 닫는 괄호)
  else:
    tmp=0
    # 여는 괄호가 나올 때까지 숫자를 더해줌
    while stk and str(stk[-1]).isnumeric():
      tmp+=stk.pop()

    if not stk:
      # 잘못된 괄호열
      flag=False
      break

    if stk[-1]=='(' and c==')':
      stk.pop()
      stk.append(2) if tmp==0 else stk.append(tmp*2)
    elif stk[-1]=='[' and c==']':
      stk.pop()
      stk.append(3) if tmp==0 else stk.append(tmp*3)
    else:
      flag=False
      break

# 숫자만 남아있는 것이 아니면 잘못된 괄호열이므로 0을 출력
for n in stk:
  if not str(n).isnumeric():
    flag=False
    break
print(sum(stk)) if flag else print(0)