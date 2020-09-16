;; 39. Definir las funciones ieee-754 que reciba un número y devuelva una lista con los 32 bits correspondientes a su representación en notación de punto flotante según la
;; norma IEEE-754 (single) y bin2hex que reciba una lista de bits y devuelva una cadena con su representación en hexadecimal.

(defn signo [n] (if (neg? n) '(1) '(0)))
(defn exponente [n]
  (if (zero? n) (repeat 8 0)
      (let [repre-minima (map #(Character/getNumericValue %)
                              (Integer/toBinaryString (+ 127 (quot (Math/log (Math/abs n)) (Math/log 2)))))]
        (concat (repeat (- 8 (count repre-minima)) 0) repre-minima))))
(defn mantisa [n]
  (if (zero? n) (repeat 23 0)
      (let [m (/ (Math/abs n) (Math/pow 2 (quot (Math/log (Math/abs n)) (Math/log 2))))]
        (rest (map second (take 24 (iterate #(if (< (* 2 (first %)) 1)
                                               (list (* 2 (first %)) 0) (list (dec (* 2 (first %))) 1))
                                            (list (dec m) 1))))))))
(defn ieee-754 [n]
  (concat (signo n) (exponente n) (mantisa n)))
(defn bin2hex [n]
  (let [repre-minima (.toUpperCase (Long/toHexString
                                    (apply + (map * n (map #(Math/pow 2 %) (range (dec (count n)) -1 -1))))))]
    (str (apply str (repeat (- (inc (quot (dec (count n)) 4))
                               (count repre-minima)) "0")) repre-minima)))

;; Página web donde se pueden verificar las conversiones:
;; https://babbage.cs.qc.cuny.edu/IEEE-754.old/Decimal.html