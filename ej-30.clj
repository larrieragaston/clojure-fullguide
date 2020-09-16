;; 30. Definir la función dif-sumas que devuelva la sumatoria de los números de las filas impares menos la sumatoria de los números de las filas pares de una matriz representada mediante listas. 
;; Por ejemplo: (dif-sumas '((1 5 7)(2 4 8)(3 6 7))) → (1+5+7+3+6+7)-(2+4+8) → 15

;; Sin recursividad:
(defn transponer [m] (apply map list m))
(defn aplicar-mascara [mascara lista]
  (reduce #(if (= (first %2) 1) (concat %1 (list (second %2))) %1)
          (conj (transponer (list mascara lista)) '())))
(defn sacar-filas [matriz mascara]
  (aplicar-mascara
   (take (count matriz)
         (flatten (repeat (quot (inc (count matriz)) 2) mascara))) matriz))
(defn dif-sumas [m]
  (- (apply + (flatten (sacar-filas m '(1 0)))) (apply + (flatten (sacar-filas m '(0 1))))))
;; Con recursividad:
(defn suma [f]
  (if (empty? f) 0 (+ (first f) (suma (rest f)))))
(defn dif-sumas [m]
  (cond
    (empty? m) m
    (empty? (rest m)) (suma (first m))
    true (+ (- (suma (first m)) (suma (second m))) (dif-sumas (rest (rest m))))))