let eval_poly x poly = 
  let base = x in

  let rec eval x poly =
    match poly with 
    | [] -> 0.0
    | hd::tl -> hd *. x +. eval (x *. base) tl
  in 

  eval (float_of_int 1) (List.rev poly)

let rec derive_poly poly = 
  match poly with 
  | [] -> []
  | _::[] -> []
  | hd::tl -> (float_of_int (List.length tl)) *. hd ::derive_poly tl 
