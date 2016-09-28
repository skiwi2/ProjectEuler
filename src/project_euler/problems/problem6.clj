(ns project-euler.problems.problem6
  (:require [project-euler.shared :as shared]))

(defn sum-square-difference [n]
  {:pre [(number? n)]}
  (let [sum-squares (reduce + (map shared/square (range 1 (inc n))))
        square-sum (shared/square (reduce + (range 1 (inc n))))]
    (- square-sum sum-squares)))

(println (sum-square-difference 100))