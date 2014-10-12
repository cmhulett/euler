(in-ns 'euler.core)

(defn palindrome?
  "Returns true if input is a palindrome by comparison of string reversal."
  [val]
  (= (seq (str val)) (reverse (str val))))

;gives 698896 as the largest palindrome product for 999 and 999, which is incorrect. The largest 2 numbers can't be assumed to create the largest product that is palindromic.
(defn false-start-largest-palindrome-product
  "Returns the largest palindrome of the product of inputs. Decrements inputs until a palindrome is found."
  [num1 num2]
  (loop [val1 num1 val2 num2]
    (cond
     (palindrome? (* val1 val2)) (* val1 val2)
     (= val1 val2) (recur (dec val1) val2)
     true (recur val1 (dec val2)))))

(defn mult-seq
  "Multiply a number against all values in a sequence up to a given limit."
  [limit min-value num]
  (map
   (partial * num)
   (range min-value limit)))

(defn generate-products
  "generate products using pairs of integers between minimum and limit values."
  [min-value limit]
  (flatten (map mult-seq
                (repeat limit)
                (repeat min-value)
                (range min-value limit))))

;Second attempt, generates a sequence of all of the palindromes
;for the values and returns the max. Returns correct answer, 906609.
(defn find-largest-palindrome-product
  "Returns the largest palindrome for products from a minimum
value up to a limit."
  [min-value limit]
  (apply max
         (filter palindrome?
                 (distinct (generate-products min-value limit)))))

(defn largest-palindrome-product
  "Finds the largest palindrome of the product of two numbers
with the number of digits given."
  [digits]
  )
