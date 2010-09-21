;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;Find the sum of all the primes below two million.

(ns euler.euler-10
  (:use clojure.contrib.lazy-seqs))


(defn euler-10 [max]
  (reduce + (take-while #(< % max) primes)))
