s=input()
w=input()
print((len(s)-len(''.join(s.split(w))))//len(w))