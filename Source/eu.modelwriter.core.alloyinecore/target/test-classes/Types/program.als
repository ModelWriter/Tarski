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

/*
A
B:A
C:A
D:A

no (B & C)
no (B + C) & D 
*/

/*
A
B
rel: A -> one B
-->
all a: A | one a.rel  &&  a.rel in B
*/

/*
A
B
rel: A -> set B

all a: A | one a.rel  &&  a.rel in B
-->
all a: A | a.rel in B 
rel.univ in A 
*/

/*
A
B
C
rel: A -> B -> C
-->
all a: A | a.rel in B -> C
rel.univ.univ in A
*/

/*
A
B
C
D
rel: A -> B -> C -> D
-->
all a: A | a.rel in B -> C -> D
rel.univ.univ.univ in A 
*/

/*
A
B
C
rel: A -> (B lone -> one C)
-->
all a: A | a.rel in B -> C && 
   (all b: B | one b.(a.rel) && b.(a.rel) in C) && 
   (all c: C | lone (a.rel).c && (a.rel).c in B) 

rel.univ.univ in A 

*/





