module ferhat/Helper

/* Helper Predicates*/
pred acyclic [s: set univ, r: univ->univ] { no x: s | x in x.^r }
