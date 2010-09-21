(ns euler.euler-05)
(use 'euler.euler-utils)
;2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?



(defn euler-5 [max]
  (reduce lcm (take max (whole-numbers))))

(euler-5 20)

