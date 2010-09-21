;The sum of the squares of the first ten natural numbers is,
;1^2 + 2^2 + ... + 10^2 = 385
;The square of the sum of the first ten natural numbers is,
;(1 + 2 + ... + 10)^2 = 55^2 = 3025
;Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
; 3025 - 385 = 2640.

;Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
(ns euler.euler-06)

(use 'euler.euler-utils)

(defn sum-square [max]
  (reduce + (map #(* % %) (take max (whole-numbers)))))

(defn square-sum [max]
  (let [sum (reduce + (take max (whole-numbers)))]
    (* sum sum)))


(defn euler-6 [max]
  (- (square-sum max) (sum-square max)))

(euler-6 100)
