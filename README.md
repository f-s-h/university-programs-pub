```diff
Anmerkung: repo befindet sich noch im Aufbau
```

# Programs for University

This repository contains a few Scripts and Programs I have written during my studies of Computer Science at Technical University of Munich.

Please note, that due to copyright restrictions, there may be programs described in this file, that are not uploaded.

### Folder Structure:

The first number indicates, which programming language is used to code.
The second number describes the order, in which I attended the course.

- 0 Java
  - 0 Introduction Computer Science
  - 1 Foundations of Programming
  - 2 Algorithms and Data Structures
  - 3 Introduction Software Engineering
- 1 Assembler
  - 0 Introduction Computer Architectures
  - 1 Computer Architectures
- 2 VHDL
  - 0 Introduction Computer Architectures
- 3 C
  - 0 Introduction Computer Architectures
  - 1 Computer Architectures
  - 2 IT Security
  - 3 Operating Systems
- 4 OCaml
  - 0 Functional Programming and Verification
- 5 Pyhton
  - 0 IT Security
- 6 SQL
  - 0 Introduction Databases

## 0 Java

### 0.0 Introduction Computer Science

#### 0.0.19 Generischer Stack
Implements a generic stack.

#### 0.0.20 Rekursive Mathematik
Calculates the binomial formula and the fibonacci recursive and end recursive.

#### 0.0.21 Knoten und Baeume
Implements a binarysearch-tree for comparable, abstract datatypes.

#### 0.0.22 Mergesort
Implements mergesort recursively.

#### 0.0.25 Funktionale Pingus
Implements the methods 'map()' and 'filter()'. Map applies a function to a generic list. Filter applies a predicate to a generic list. </br>
Functional implemented.  

## 4 Ocaml

### 4.0 Fuctional Programming and Verification

#### 4.0.4 Polynomial

A polynomial formula is represented as a list of its coefficients (where index 0 represents cn: cn*x^n and index n represents c0: c0*x^0). Implemented functions:
- eval_poly x poly: evaluates the value of the poly for the given x.
- derivate poly: returns the first derivation of the given poly (as list of the coefficients)

#### 4.0.7 Binary Tree

Implements a binary tree with basic operations remove, insert, to_list and inspect

#### 4.0.8 Paeno arithmetic

Recursive implementation of the natural numbers. Converter functions:
- nat_to_int nat: Converts natural number to int 
- int_to_nat i: Converts int to natural number
Opartional functions:
- add nat nat: adds to natural numbers
- mul nat nat: multiplies two natural numbers
- pow nat1 nat2: computes nat1^nat2
- leq nat1 nat2: evaluates nat1 <= nat2  

## 5 Python

### 5.0 IT Security

#### 5.0.4 SQL-Injection with UNION
SQL Injection. Two Databases: Database from 5.0.3 without the is_secret column and the flag inside the new table (old table name: internet_index). The structure of the new table "tumoogleplus_users":

| id  | username | password  |
| --- | -------- | --------- |
| 1   | admin    | flag{...} |
| ... | ...      | ...       |

The exploit is based on the concatenation of the two tables via UNION.

#### 5.0.5 Blind SQL-Injection

Blind SQL-Injection to breach the admin-password. The password is stored unencrypted inside the database, used to authenticate the user. <br/>
The exploit checks (for every letter), wether there is a combination of the username 'admin' and a password starting with that letter. (For example "username = 'admin' and password like 'f%'"). When the server responds positive, than continue with the second letter until no letter is correct anymore.


## 6 SQL

#### 6.0.4 World champion

This exercise does not use the "Uni-Schema". The request evaluates the world champion from a tournament. Tables:
</br>
Spieler
| SpielerID | Name | Alter | Team |
| --------- | ---- | ----- | ---- |

Herkunft
| Team | Kontinent |
| ---- | --------- |

Einsatz
| SpielerID | Datum | Ort | Tore |
| --------- | ----- | --- | ---- |


#### 6.0.6 Third semester lecture

Recursive implementation to find all Vorlesungen, that have a vorgaenger, that has a vorgaenger.

#### 6.0.7 Second place

Based on table from 6.0.2. Returns all second places. One implementation with a correlated suqrequest and the other with counting. 

#### 6.0.8 Earliest semester

Evaluates recursively the earliest semester for all courses.

