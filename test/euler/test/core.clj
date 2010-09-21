(ns euler.test.core
  (:use [euler.euler-01] :reload)
  (:use [euler.euler-02] :reload)
  (:use [euler.euler-03] :reload)
  (:use [euler.euler-04] :reload)
  (:use [euler.euler-05] :reload)
  (:use [euler.euler-06] :reload)
  (:use [euler.euler-07] :reload)
  (:use [euler.euler-08] :reload)
  (:use [euler.euler-09] :reload)
  (:use [euler.euler-10] :reload)
  (:use [clojure.test]))


(deftest test-euler-01
  (is (= 233168 (euler-1 1000))))

(deftest test-euler-01-with-10
  (is (= 23 (euler-1 10))))

(deftest test-euler-02
  (is (= 4613732 (euler-2 4000000))))

(deftest test-euler-03
  (is (= 6857 (euler-3 600851475143))))

(deftest test-euler-04
  (is (= 906609 (euler-4))))

(deftest test-euler-05
  (is (= 232792560 (euler-5 20))))

(deftest test-euler-06
  (is (= 25164150 (euler-6 100))))

(deftest test-euler-07
  (is (= 104743 (euler-7 10001))))


(deftest test-euler-08
  (let
    [big-number "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"]
    (is (= 40824 (euler-8 big-number )))))

(deftest test-euler-09
  (is (= 31875000 (euler-9))))

(deftest test-euler-10
  (is (= 17 (euler-10 10))))

(deftest test-euler-10-a-million  (is (= 142913828922 (euler-10 2000000))))
