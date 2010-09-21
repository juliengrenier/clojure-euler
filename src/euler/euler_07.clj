;By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;What is the 10001st prime number?
(ns euler.euler-07)
(use 'euler.euler-utils)

(defn euler-7 [nth]
  (last (take nth (primes))))

(euler-7 10001)




