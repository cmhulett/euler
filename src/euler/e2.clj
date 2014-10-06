(in-ns 'euler.core)

;user> (even-sum (max-value-fib-seq nil))
;4613732

(defn fib-seq
  "Returns a lazy sequence of fibbonaci values."
  []
  ((fn rfib [a b]
       (cons a (lazy-seq (rfib b (+ a b)))))
    0 1))

(defn max-value-fib-seq
  "Returns sequence of fibbonaci values up to max value. Defaults
to a max of 4,000,000 for nil input."
  [max-value]
  (take-while (partial > (or max-value 4000000)) (fib-seq)))

(defn even-sum
  "Reduce a collection to the sum of it's even values."
  [col]
  (reduce + (filter even? col)))
