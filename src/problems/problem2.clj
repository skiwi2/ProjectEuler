(ns problems.problem2
  (:require shared))

(defn even-fibonacci-numbers []
  (->> (take-while #(< % 4000000) (shared/fib-seq))
       (filter even?)
       (reduce +)))

(println (even-fibonacci-numbers))