(in-ns 'euler.core)

;smallest positive number evenly divisible by 1..20

(defn div-1-n?
  "Returns true if input is evenly divisble by 1..n"
  [limit num]
  (every? (partial div? num) (range 1 (+ 1 limit))))

(defn not-div-1-n?
  "Returns true if input is not evenly divisble by 1..n"
  [limit num]
  (not (div-1-n? limit num)))

;just trying out different strategies, this works but it's probably always going to make sense to either use a anonymous function (take-while #(not (bool? %)... or use (first (drop-while (complement ... like below if only the last value is needed.
(defn take-while-not
"Take while pred is not true. Same as take-while with inverted logical test."
{:static true}
([pred]
   (fn [rf]
     (fn
       ([] (rf))
       ([result] (rf result))
       ([result input]
          (if (not (pred input))
            (rf result input)
            (reduced result))))))
([pred coll]
   (lazy-seq
    (when-let [s (seq coll)]
      (when (not (pred (first s)))
        (cons (first s) (take-while-not pred (rest s))))))))

;should work but starts taking really long for n > 16
(defn least-common-multiple
  "Returns least common multiple for 1 to n."
  [n]
  (first (drop-while (complement (partial div-1-n? n)) (iterate inc n))))

;soln from http://clojure-euler.wikispaces.com/Problem+005
;Much faster
(defn gcd
  [a b]
  (if (zero? b) a
      (recur b (mod a b))))

(defn lcm
  [a b]
  (/ (* a b) (gcd a b)))

;(reduce #(lcm %1 %2) (range 1 21))
; -> 232792560
