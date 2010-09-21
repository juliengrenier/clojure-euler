;A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
;a^2 + b^2 = c^2
;For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;Find the product abc.
(ns euler.euler-09)

(use 'euler.euler-utils)

(defn temp [a]
  (map #(* a %) (take 10 (whole-numbers a))))

(defn euler-9 []
  (map temp (take 10 (whole-numbers))))

(euler-9 )