s = input()
sub_s = set()
for i in range(len(s)):
  for j in range(len(s)-i):
    sub_s.add(s[j:j+i+1])
print(len(sub_s))