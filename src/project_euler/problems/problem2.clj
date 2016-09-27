(ns project-euler.problems.problem2
  (:require [project-euler.shared :as shared]))

(defn even-fibonacci-numbers []
  (->> (take-while #(< % 4000000) (shared/fib-seq))
       (filter even?)
       (reduce +)))

(println (even-fibonacci-numbers))