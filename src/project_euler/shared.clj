(ns project-euler.shared
  (:require [clojure.math.numeric-tower :as math]))

(defn fib-seq []
  ((fn fib-seq-gen [a b]
     (cons a (lazy-seq (fib-seq-gen b (+ a b)))))
    0 1))

(defn prime-seq []
  ((fn prime-seq-gen [s]
    (cons (first s)
          (lazy-seq (prime-seq-gen (filter #(not= 0 (mod % (first s))) (rest s))))))
      (iterate inc 2)))

(defn first-prime-factor [n]
  {:pre [(>= n 2)]}
  (first (filter #(= 0 (mod n %)) (prime-seq))))

(defn prime-factors [n]
  {:pre [(>= n 2)]}
  (loop [n n s []]
    (if (= n 1)
      s
      (recur (/ n (first-prime-factor n))
             (conj s (first-prime-factor n))))))

(defn log [b n]
  {:pre [(number? b) (number? n)]}
  (/ (Math/log10 n) (Math/log10 b)))

(defn square [n]
  {:pre [(number? n)]}
  (math/expt n 2))

(defn prime-seq-sieve [n]
  {:pre [(>= n 2)]}
  (let [nsqrt (math/sqrt n)]
    (loop [s (range 2 (inc n))
           p 2]
      (if (> p nsqrt)
        s
        (recur (concat (filter #(<= % p) s)
                       (filter #(and (> % p) (not= 0 (mod % p))) s))
               (first (filter #(> % p) s)))))))