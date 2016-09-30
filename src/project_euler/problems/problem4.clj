(ns project-euler.problems.problem4
  (:require [clojure.math.combinatorics :as combinatorics]))

(defn- three-digit-numbers []
  (range 100 999))

(defn- palindrome? [n]
  {:pre [{number? n}]}
  (let [s (str n)]
    (= s (clojure.string/reverse s))))

(defn largest-palindrome-product []
  (->> (combinatorics/cartesian-product (three-digit-numbers) (three-digit-numbers))
       (map (fn [[x y]] (* x y)))
       (filter palindrome?)
       (apply max)))

(println (largest-palindrome-product))