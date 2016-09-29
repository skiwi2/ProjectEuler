(ns project-euler.problems.problem10
  (:require [project-euler.shared :as shared]))

(defn summation-of-primes [n]
  (reduce + (shared/prime-seq-sieve n)))

(println (summation-of-primes 2000000))