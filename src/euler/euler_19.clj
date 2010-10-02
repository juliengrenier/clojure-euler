;You are given the following information, but you may prefer to do some research for yourself.

;1 Jan 1900 was a Monday.
;Thirty days has September,
;April, June and November.
;All the rest have thirty-one,
;Saving February alone,
;Which has twenty-eight, rain or shine.
;And on leap years, twenty-nine.
;A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
;How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

(ns euler.euler-19)

(import
  '(java.util Calendar)
  '(java.util Date))

(def *start-time* (doto (Calendar/getInstance) (.setTime (new Date 1 0 1))))

(def *end-time* (doto (Calendar/getInstance) (.setTime (new Date 100 11 31))))

(defn is-sunday? [cal]
  (= Calendar/SUNDAY (.get cal Calendar/DAY_OF_WEEK)))

(defn is-first-day-of-month? [cal]
  (= 1 (.get cal Calendar/DAY_OF_MONTH)))


(defn date-range [current-time end-time]
  (letfn [
    (make-date-range [dates current-time end-time]
      (let [current-date (.clone current-time)
            noop (.add current-time Calendar/DATE 1)]
        (if (.after current-time end-time)
          dates
          (recur (conj dates current-date) current-time end-time))))]
    (make-date-range [] current-time end-time)))


(defn euler-19 []
  (count (filter #(and (is-sunday? %) (is-first-day-of-month? %)) (date-range *start-time* *end-time*))))

(euler-19 )