;Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
; begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this
; value by its alphabetical position in the list to obtain a name score.
;
;For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is
; the 938th name in the list. So, COLIN would obtain a score of 938 * 53 = 49714.
;
;What is the total of all the name scores in the file?
(ns euler.euler-22
  (:refer-clojure :exclude [spit])
  (:use clojure.contrib.duck-streams)
  (:use euler.euler-utils :reload))


(def *character-value* (weighted-collections "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))

(defn read-names [filename]
  (seq (.split (.replaceAll (first (line-seq (reader filename))) "\"" "") ",")))


(defn calculate-string-value [string]
  (reduce + (map #(get *character-value* %) string)))


(defn calculate-indexed-string-value [[index value]]
 (* index (calculate-string-value value)))

(defn euler-22 [filename]
  (reduce + (map calculate-indexed-string-value (indexed-collections (sort (read-names filename))))))


;(count (indexed-collections (sort (read-names))))

(euler-22 "resources/names.txt")






