type tree = Empty | Node of (int * tree * tree) 

let node v l r = Node (v, l, r)

let leaf _ = Empty

let inspect n =
  match n with
  | Empty -> None
  | Node (v, l, r) ->  Some(v, l, r)

let t1 = Node (8, Node (1, Empty, Node(6, Empty, Empty)), Node (12, Node(9, Empty, Empty), Node(42, Empty, Empty)))

let rec to_list tr = 
  match tr with
  | Empty -> []
  | Node (v, Empty, Empty) -> [v]
  | Node (v, Empty, r) -> v :: (to_list r)
  | Node (v, l, Empty) -> (to_list l) @ [v]
  | Node (v, l, r) -> (to_list l) @ (v :: (to_list r))

let rec insert vl tr = 
  match tr with
  | Empty -> Node (vl, Empty, Empty)
  | Node (v, l, r) -> if v = vl then tr else if v > vl then Node (v, (insert vl l), r) else Node(v, l, (insert vl r)) 

let rec remove_max tr = 
  match tr with
  | Empty -> Empty
  | Node(v,l,r) -> if r <> Empty then Node(v, l, remove_max r) else Empty

let rec get_max tr = 
  match tr with
  | Empty -> failwith "Cannot get a max value, when the tree is empty."
  | Node(v,l,r) -> if r <> Empty then get_max r else v

let rec remove x tr = 
  match tr with
  | Empty -> Empty
  | Node (v, l, r) ->
    if x > v then 
      Node (v, l, remove x r)
    else if v < x then
      Node (v, remove x l, r)
    else
      (*Delete*)
      match l, r with 
      | Empty, _ -> r
      | _, Empty -> l
      | l, r -> Node(get_max l, remove_max l, r)

