pas = input("Enter a password of minimum 8 characters: ")
n = len(pas)
upp = 0
low = 0
num = 0
spec = 0
deduc = 0
d = 0
temp = 0
counts = dict()
for i in range(len(pas)):
    if pas[i].isupper():
        upp = upp + 1 
    elif pas[i].islower():
        low = low + 1
    elif pas[i].isdigit():
        num = num + 1
    else:
        spec = spec + 1
    counts[pas[i]] = counts.get(pas[i],0) + 1
print("U L D S")
print(upp,low,num,spec)
sum =   n*4
s = 0
if num == n:
    d = n
    s = sum + num*4
elif upp+low == n:
    d = n
    s = sum + (n-upp)*2 + (n-low)*2
elif upp == n:
    d = n
elif low == n:
    d = n
else:
    if low == 0:
        s = sum + (n-upp)*2 + num*4 
    elif upp == 0:
        s = sum + (n-low)*2 + num*4 
    else:
        s = sum + (n-upp)*2 + (n-low)*2 + num*4 + spec*6
v1 = pas[0]
v2 = pas[1]
v3 = pas[2]
for i in range(len(pas)):
    if i < (n - 1):
        v1 = pas[i]
        v2 = pas[i+1]
        if (ord(v2) - ord(v1)) == 1:
            if i <= (n-3):
                v3  = pas[i+2]
                if (ord(v3) - ord(v2)) ==1:
                    temp = temp + 1
            v1 = v2
            v2 = v3
        else:
            if i <= (n-3):
                v1 = v2
                v2 = v3
seq = 0
for i in range(len(pas)):
    if i != (n - 1):
        if pas[i]==pas[i+1]:
            seq = seq + 1
deduc = d + temp*3 + seq*3
tot = 0
for (k,v) in counts.items():
    if v > 1:
        tot = tot + v
sum = s - deduc - tot*3
print("Score", sum)

