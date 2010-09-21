(ns euler.euler-utils)

(defn whole-numbers
  ([] (whole-numbers 1))
  ([n] (iterate inc n)))


(defn multiple-of [n i] (= (mod i n) 0))


(defn fib-sequence []
  (fn [[x y]]
    (map first
      (iterate
        (fn [[a b]] [b (+ a b)]) [x y]))))


(defn fibonnacci
  ([n] (fibonnacci n [0 1]))
  ([n [x y]] (last (take n ((fib-sequence) [x y])))))

(defn is-prime? [n]
  (empty? (filter #(and (> n %) (= (mod n %) 0)) (take (dec (Math/sqrt n)) (whole-numbers 2) ))))

(defn primes []
  (filter  is-prime? (whole-numbers 2)))



(defn gcd [a b]
  (let [i (max a b)
        j (min a b)]
        (if (= j 0)
          i
          (recur j (mod i j)))))

(defn lcm [a b]
  (* a (int (/ b (gcd a b)))))

(defn factors [n]
    (loop [n n, s 2, a '()]
        (if-let [f (first (filter #(zero? (mod n %)) (take-while #(<= % (Math/sqrt n)) (range  s n))))]
            (recur (/ n f) f (conj a f))
            (conj a n))))


