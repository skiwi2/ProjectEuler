(ns problems.problem4)

(defn three-digit-numbers []
  (range 100 999))

(defn palindrome? [n]
  {:pre [{number? n}]}
  (let [s (str n)]
    (= s (clojure.string/reverse s))))

;TODO convert project to Leiningen and use clojure.math.combinatorics/cartesian-product via :require
(defn largest-palindrome-product []
  (->> (for [x (three-digit-numbers) y (three-digit-numbers)] [x y])
       (map #(* (first %) (last %)))
       (filter palindrome?)
       (apply max)))

(println (largest-palindrome-product))