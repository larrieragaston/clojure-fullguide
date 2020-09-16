;; 21. Definir una función que reciba un número n y devuelva el enésimo número primo.

(defn primo? [n]
  (or (= n 2)
      (and (not= n 1)
           (pos? (rem n 2))
           (not-any? #(zero? (rem n %)) (range 3 (inc (Math/sqrt n)))))))
(defn secuencia-de-primos
  ([] (cons 2 (lazy-seq (secuencia-de-primos 3))))
  ([n] (if (primo? n) (cons n (lazy-seq (secuencia-de-primos (+ n 2))))
           (secuencia-de-primos (+ n 2)))))
(defn enesimo-primo [n]
  (nth (secuencia-de-primos) (dec n)))
