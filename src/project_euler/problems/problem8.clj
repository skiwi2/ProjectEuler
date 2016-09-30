(ns project-euler.problems.problem8
  (:require [clojure.java.io :as io]))

(defn- read-1000-digit-number []
  (with-open [rdr (io/reader (io/resource "problem8.txt"))]
    (apply str (line-seq rdr))))

(defn largest-product-in-a-series [len]
  {:pre [(pos? len)]}
  (->> (partition len 1 (read-1000-digit-number))
       (map (partial map (comp read-string str)))
       (map (partial reduce *))
       (apply max)))

(println (largest-product-in-a-series 13))