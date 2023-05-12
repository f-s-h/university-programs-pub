fold_left:
// 0. Parameters at function call: rdi: fn address, esi: init, rdx: len, rcx: arr adress
loop:
// 1. for(; ic < len;)
cmp rdx, 0
jle end
// 2.1. save caller values
push rdi
push rsi
push rdx
push rcx
// 2.2.1 set rax to functionadress
mov rax, rdi

// 2.2.2 set parameters init(esi), element(arr[ic]) (in rcx)
mov rdi, rsi
xor rsi, rsi
mov esi, [rcx]
// 2.3. call function 
call rax
// 2.4. restore caller values
pop rcx
pop rdx
pop rsi
pop rdi
// 2.5. store return value (rax) in init (rsi)
mov rsi, rax
// 2.6. increase index
add rcx, 4 
dec rdx
// 2.7. jump back to 2.
jmp loop

end:
// 3. Set return value to init and return
mov rax, rsi
ret
