(ns project-euler.problems.problem11
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))

(defn read-grid []
  (with-open [rdr (io/reader (io/resource "problem11.txt"))]
    (->> (line-seq rdr)
         (str/join " ")
         (#(str/split % #" "))
         (map (comp read-string #(str "10r" %)))
         vec)))

(defn grid-index [size n]
  (list (- n (* size (int (math/floor (/ n size)))))
        (int (math/floor (/ n size)))))

(defn mirror-horizontal [size index]
  (list (- (dec size) (first index))
        (last index)))

(defn to-full-index [size index]
  (+ (* size (last index)) (first index)))

(defn incrementing-by? [n s]
  (apply = n (map - (rest s) s)))

(defn diagonal-indices-in-grid [size total n]
  (->> (range 0 total)
       (group-by #(mod % (inc size)))
       vals
       (mapcat (partial partition n 1))
       (filter #(incrementing-by? 1 (map (comp first (partial grid-index size)) %)))))

(defn anti-diagonal-indices-in-grid [size total n]
  (->> (range 0 total)
       (group-by #(mod % (inc size)))
       vals
       (map (partial map #(to-full-index size (mirror-horizontal size (grid-index size %)))))
       (mapcat (partial partition n 1))
       (filter #(incrementing-by? -1 (map (comp first (partial grid-index size)) %)))))

(defn horizontal-indices-in-grid [size total n]
  (->> (range 0 total)
       (group-by #(last (grid-index size %)))
       vals
       (mapcat (partial partition n 1))))

(defn vertical-indices-in-grid [size total n]
  (->> (range 0 total)
       (group-by #(first (grid-index size %)))
       vals
       (mapcat (partial partition n 1))))

(defn largest-product-in-grid [n]
  {:pre [(pos? n)]}
  (let [grid (read-grid)
        total (count grid)
        size (int (math/sqrt total))]
    (->> (concat (diagonal-indices-in-grid size total n)
                 (anti-diagonal-indices-in-grid size total n)
                 (horizontal-indices-in-grid size total n)
                 (vertical-indices-in-grid size total n))
         (map (partial map (partial nth grid)))
         (map (partial reduce *))
         (apply max))))

(println (largest-product-in-grid 4))