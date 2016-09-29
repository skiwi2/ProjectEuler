(ns project-euler.problems.problem9
  (:require [project-euler.shared :as shared]
            [clojure.math.combinatorics :as combinatorics]))

(defn special-pythagorean-triplet []
  (->> (combinatorics/cartesian-product (range 0 1001)
                                        (range 0 1001)
                                        (range 0 1001))
       (filter (fn [[a b c]] (and (< a b) (< b c))))
       (filter (fn [[a b c]] (= (+ a b c) 1000)))
       (filter (fn [[a b c]] (let [as (shared/square a)
                                   bs (shared/square b)
                                   cs (shared/square c)]
                               (= (+ as bs) cs))))
       (first)
       (apply *)))

(println (special-pythagorean-triplet))