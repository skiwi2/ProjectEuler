(ns project-euler.problems.problem12
  (:require [project-euler.shared :as shared]))

(defn highly-divisible-triangular-number [n]
  {:pre [(pos? n)]}
  (->> (shared/triangle-numbers)
       (filter #(>= % 2))
       (filter #(> (count (shared/divisors %)) n))
       first))

(println (highly-divisible-triangular-number 500))