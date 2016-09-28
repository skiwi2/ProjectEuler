(ns project-euler.problems.problem5
  (:require [project-euler.shared :as shared]
            [clojure.math.numeric-tower :as math]))

(defn smallest-multiple [maximum]
  {:pre [(number? maximum)]}
  (->> (take-while #(<= % maximum) (shared/prime-seq))
       (map #(int (math/expt % (math/floor (shared/log % maximum)))))
       (reduce *)))

(println (smallest-multiple 20))