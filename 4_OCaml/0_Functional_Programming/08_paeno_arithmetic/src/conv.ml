open Type

let rec int_to_nat i = if i <= 0 then Zero else Succ (int_to_nat (i - 1))

let rec nat_to_int n = match n with Zero -> 0 | Succ x -> 1 + nat_to_int x
