(in-ns 'euler.core)

;user> (reduce + (filter mult3or5? (range 0 10)))
;23
;user> (reduce + (filter mult3or5? (range 0 1000)))
;233168

(defn mult?
  "Returns true if input is a multiple of divisor"
  [input divisor]
  (zero? (mod input divisor)))

(defn mult3or5?
  "Returns true if input is a multiple of 3 or 5."
  [x]
  (or (mult? x 3) (mult? x 5)))
