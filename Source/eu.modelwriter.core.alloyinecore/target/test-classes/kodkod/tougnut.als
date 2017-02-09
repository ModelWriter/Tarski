model internal/tougnut
  
open util/ordering[Cell]
  
sig Cell { covered: Cell -> Cell -> Cell }
  
pred covering() { 
 // opposite corners not on the board 
 let board = Cell->Cell - (first->first + last->last) | covered in board->board
 
 // covering relation is symmetric 
 all x,y: Cell | y.(x.covered)->x->y in covered
 
 // each pair of cells on the board should be covered 
 // by a domino, which also covers ONE of its neighbors 
 all x,y: Cell | one y.(x.covered) && y.(x.covered) in  (prev[x]+next[x])->y + x->(prev[y] + next[y])

}

run covering for 10
