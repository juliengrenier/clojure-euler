(ns euler.euler-03)

;The prime factors of 13195 are 5, 7, 13 and 29.
;What is the largest prime factor of the number 600851475143 ?

(use 'euler.euler-utils)



(defn euler-3 [n]
  (first (factors n)))

(euler-3 600851475143)



