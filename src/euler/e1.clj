(in-ns 'euler.core)

;user> (reduce + (filter mult3or5? (range 0 10)))
;23
;user> (reduce + (filter mult3or5? (range 0 1000)))
;233168

(defn mult3?
  "Returns true if input is evenly divisible by 3."
  [x]
  (= 0 (mod x 3)))

(defn mult5?
  "Returns true if input is evenly divisible by 5."
  [x]
  (= 0 (mod x 5)))

(defn mult3or5?
  "Returns true if input is a multiple of 3 or 5."
  [x]
  (or (mult3? x) (mult5? x)))
