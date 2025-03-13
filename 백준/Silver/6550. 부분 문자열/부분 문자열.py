while True:
  try:
    s, t = input().split()

    result = ''
    i = 0
    for c in s:
      while i < len(t):
        if c == t[i]:
          result += c
          i += 1
          break
        i += 1

    print('Yes') if result == s else print('No')
  except:
    break