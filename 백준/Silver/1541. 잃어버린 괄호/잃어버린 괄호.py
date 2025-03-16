expr = input()

total = 0
sub_total = 0

target = ''
for i in range(len(expr)-1, -1, -1):
  if expr[i] in ('+', '-'):
    sub_total += int(target)
    target = ''

    if expr[i] == '-':
      total += -sub_total
      sub_total = 0
  else:
    target = expr[i] + target 
    
total += sub_total + int(target)
print(total)