(ns euler.euler-01)

(use 'euler.euler-utils)


;If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;Find the sum of all the multiples of 3 or 5 below 1000.
(defn euler-1 [n] (reduce + (filter #(or (multiple-of 3 %) (multiple-of 5 %)) (take (dec n) (whole-numbers)))))


