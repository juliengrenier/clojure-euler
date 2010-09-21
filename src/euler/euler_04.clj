(ns euler.euler-04)
(use 'euler.euler-utils)

;A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.
;Find the largest palindrome made from the product of two 3-digit numbers.


(defn reverse-int
  ([n] (reverse-int n 0))
  ([a b]
    (if (= a 0)
      b
      (recur (int (/ a 10.0)) (+ (* b 10) (mod a 10))))))

(defn is-palindrome [n]
  (= n (reverse-int n))
  )

(defn euler-4
  ([] (euler-4 999 999 0))
  (
    [a b x]
    (if (< a 101)
      x
      (if (< b a)
        (recur (- a 1) 999 x)
        (if (<= (* a b) x)
          (recur (- a 1), 999, x)
          (if (is-palindrome (* a b))
            (recur (- a 1) 999 (* a b))
            (recur a, (- b 1), x)))))))


(euler-4)


