(ns project-euler.problems.problem3
  (:require [project-euler.shared :as shared]))

(defn largest-prime-factor [n]
  (apply max (shared/prime-factors n)))

(println (largest-prime-factor 600851475143))