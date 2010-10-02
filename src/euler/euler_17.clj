;If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
; 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
;If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
;NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
; (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with
; British usage.
(ns euler.euler-17
  (:use euler.euler-utils))

(def *digits* {1 "one", 2 "two", 3 "three", 4 "four", 5 "five", 6 "six", 7 "seven", 8 "eight", 9 "nine", 10 "ten"
               11 "eleven", 12 "twelve", 13 "thirteen", 14 "fourteen", 15 "fifteen", 16, "sixteen", 17 "seventeen", 18 "eighteen"
               19 "nineteen", 1000 "one thousand"}
  )

(def *ties*
  {20 "twenty ", 30 "thirty ", 40 "forty ", 50 "fifty ", 60 "sixty ", 70 "seventy ", 80 "eighty ", 90 "ninety "})

(def *others*
  {100 " hundred and "})

(defn integer-division [n d]
  (int (/ n d)))

(defn remainder [n base]
  (rem n (* base (integer-division n base))))




(defn number-to-string [n]
  (letfn [(number-to-seq [n]
    (if (get *digits* n)
      (get *digits* n)
      (if (>= n 100)
        (concat
          (get *digits* (integer-division n 100)) (get *others* 100)
          (number-to-seq (remainder n 100)))
        (if (>= n 10)
          (concat (get *ties* (* 10 (integer-division n 10)))
            (number-to-seq (remainder n 10)))))))
          ]
    (let [result (apply str (number-to-seq n))]
      (if (.endsWith result "and ")
        (.substring result 0 (- (.length result) 5))
        result))))


(defn filter-space [string]
  (.replaceAll string " " ""))


(defn count-char-in-string [string]
  (count (filter-space string)))

(defn count-char-in-number [n]
  (count-char-in-string (number-to-string n)))

(defn euler-17 [n]
  (reduce + (map count-char-in-number (take n (whole-numbers)))))

