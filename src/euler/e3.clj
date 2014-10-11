(in-ns 'euler.core)

;The prime factors of 13195 are 5, 7, 13 and 29.
;What is the largest prime factor of the number 600851475143?

;user> (largest-prime-factor 13195)
;29
;user> (largest-prime-factor 600851475143)
;6857

(defn div?
  "Returns true if first input is evenly divisible by the second."
  [x y]
  (zero? (rem x y)))

(defn sqrt
  "Returns an integer representation of the square root of the input."
  [num]
  (int (Math/sqrt num)))


(defn largest-prime-factor
  "Returns the largest prime factor of a given number.
Explanation of conditions:
1. If d is greater than the sqaure root of the original number num, number itself must be prime.
2. If d is equal to n we've found the prime, return n.
3. If d is a factor of n, factor d from n and loop.
4. Else increment d and loop."
  [num]
  (loop [n num d 2]
    (cond
     (> d (sqrt num)) n
     (= n d) n
     (div? n d) (recur (/ n d) d)
     true (recur n (inc d)))))
