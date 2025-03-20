vowels = 'aeiou'
consonants = 'bcdfghjklmnpqrstvwxyz'


while True:
  s = input()
  if s == 'end':
    break

  flag = False
  vowel_count = 0
  consonant_count = 0
  prev = ''

  for c in s:
    # 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    if prev == c and c not in ('e', 'o') :
      flag = False
      break
    else:
      prev = c

    if c in vowels:
      flag = True
      vowel_count += 1
      consonant_count = 0
    else:
      vowel_count = 0
      consonant_count += 1
    
    # 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    if vowel_count == 3 or consonant_count == 3:
      flag = False
      break

  # 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
  if flag == False:
    print(f'<{s}> is not acceptable.')
  else:
    print(f'<{s}> is acceptable.')