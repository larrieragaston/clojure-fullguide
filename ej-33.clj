;; 33. Definir una función que devuelva un vector con los números primos menores que 100.

(defn primo? [n]
  (or (= n 2)
      (and (not= n 1)
           (pos? (rem n 2))
           (not-any? #(zero? (rem n %)) (range 3 (inc (Math/sqrt n)))))))
(defn primos-menores-que-100 []
  (vec (filter primo? (range 1 100))))