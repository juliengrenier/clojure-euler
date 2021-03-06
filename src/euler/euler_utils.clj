(ns euler.euler-utils
  (:use clojure.contrib.lazy-seqs))


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

(defn transpose
  ([matrix] (transpose matrix []))
  ([matrix result]
    (if (some empty? matrix)
      result
      (recur (map next matrix) (conj result (map first matrix))))))

(defn matrix-get [matrix x y]
  (get (get matrix y) x))

(defn row-count [matrix]
  (count matrix))

(defn column-count [matrix]
  (count (first matrix)))

(defn all-factors [n]
  (filter #(zero? (mod n %)) (take n (whole-numbers ))))

(defn count-factors [n]
  (* 2 (count (filter #(zero? (rem n %)) (take (dec (Math/sqrt n)) (whole-numbers ))))))

(defn triagle-numbers
  ([] (triagle-numbers 1))
  ([n] (lazy-seq (cons (/ (* (inc n) n) 2) (triagle-numbers (inc n))))))


(defn number-to-seq [number]
  (map #(Integer/parseInt (str %)) (str number) ))

(defn fact! [n]
 (reduce * (range 1 n)))

(defn indexed-collections [col]
  (map vector (whole-numbers) col))

(defn weighted-collections [col]
  (reduce merge (map hash-map col (whole-numbers))))