;n! means n  (n  1)  ...  3  2  1

;Find the sum of the digits in the number 100!
(ns euler.euler-20
  (:use euler.euler-utils))

(defn euler-20 [n]
  (reduce + (number-to-seq (fact! n))))


(euler-20 100)