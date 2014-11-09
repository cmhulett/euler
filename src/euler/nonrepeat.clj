(in-ns 'euler.core)

;O(n^2)
(defn first-non-repeat
  "Find first non-repeating character in a string"
  [input]
  (str (first (filter (fn [x] (= 1 (count-chars x input))) input))))

(defn count-chars
  "Count the number of times a character occurs in a string"
  [character string]
  (count (filter (fn [x] (= x character)) string)))

;O(n). first-non-repeat was fine for short strings, but (str (apply str (repeat 10000 "A")) "L") was taking 17.5sec because O(n^2). This impl runs in linear time, by creating a frequency map from the string and returning the first character that has a frequency 1.
(defn first-nonrepeat
  "Creates frequency map from string and returns first character in string that only occurs once in the string"
  [input]
  (let [ freq-map (frequencies input)]
    (str (first (drop-while (comp not #{1} freq-map)
                            (keys freq-map))))))
