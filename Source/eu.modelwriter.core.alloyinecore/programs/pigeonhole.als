sig Pigeon { hole: Hole }

sig Hole {} 

fact {no disj p1, p2: Pigeon | p1.hole = p2.hole}

pred aPigeonPerHole() { 
	// holes are not shared 
	-- all p1, p2: Pigeon | p1 != p2 implies p1.hole != p2.hole 
	-- all p1, p2: Pigeon, h1, h2: Hole |  p1 != p2 => p1.hole != p2.hole
	-- no disj p1, p2: Pigeon | p1.hole = p2.hole
	

} 

run aPigeonPerHole for exactly 4 Pigeon, exactly 4 Hole
