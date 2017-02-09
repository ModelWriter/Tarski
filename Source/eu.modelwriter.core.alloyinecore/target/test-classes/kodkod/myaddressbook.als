model appendixA/addressBook2

sig Addr, Name { }

sig Book {
	addr: Name -> (Name + Addr)
	}

/* 

----------------
x: m e

----------------
r: A m -> n B
all a: A | n a.r
all b: B | m r.b

----------------
r: A -> (B m -> n C)
all a: A | a.r in B m -> n C

----------------
r: (A m -> n B) -> C
all c: C | r.c in A m -> n B
----------------

*/

--addr: Book -> (Name lone -> Addr)
pred show1 {
	all b: Book | b.addr in Name lone -> Addr
}

//r: (A m -> n B) -> C
pred show2 {
	all b: Book | b.addr in Name lone -> Addr
}

run show1 for 3
