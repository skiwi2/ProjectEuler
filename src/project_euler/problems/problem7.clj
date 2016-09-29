(ns project-euler.problems.problem7
  (:require [project-euler.shared :as shared]))

(defn nth-prime-number [n]
  {:pre [(number? n)]}
  (nth (shared/prime-seq) (dec n)))

(println (nth-prime-number 10001))