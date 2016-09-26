(ns problems.problem3
  (:require shared))

(defn largest-prime-factor [n]
  (apply max (shared/prime-factors n)))

(println (largest-prime-factor 600851475143))