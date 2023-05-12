open Type

let rec add a b = match a with Zero -> b | Succ a' -> add a' (Succ b)

let rec mul a b = match a with Succ a' -> add b (mul a' b) | Zero -> Zero

let rec pow a b = match b with Zero -> Succ Zero | Succ b' -> mul a (pow a b')

let rec leq a b =
  match (a, b) with Succ a', Succ b' -> leq a' b' | Zero, _ -> true | _ -> false
