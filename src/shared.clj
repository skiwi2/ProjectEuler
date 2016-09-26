(ns shared)

(defn fib-seq []
  ((fn fib-seq-gen [a b]
     (cons a (lazy-seq (fib-seq-gen b (+ a b)))))
    0 1))