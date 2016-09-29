(defproject project-euler "0.1.0-SNAPSHOT"
  :description "A collection of Project Euler problems solved in Clojure"
  :url "https://github.com/skiwi2/ProjectEuler"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.3"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :jvm-opts ["-Xss4m" "-Xmx8g"])
