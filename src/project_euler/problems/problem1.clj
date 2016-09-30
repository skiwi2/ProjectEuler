(ns project-euler.problems.problem1)

(defn- divisible-by?
  [x divisor]
  (zero? (mod x divisor)))

(defn multiples-of-3-and-5 []
  (->> (range 1000)
       (filter (some-fn
                 #(divisible-by? % 3)
                 #(divisible-by? % 5)))
       (reduce +)))

(print (multiples-of-3-and-5))