;; 29. Definir la función col-par-fil-imp que devuelva la matriz resultante de tomar de una matriz las columnas pares y, de estas, las filas impares. 
;; Por ejemplo: (col-par-fil-imp '((1 5 7 9)(2 4 8 4)(3 6 7 8)(6 8 7 3))) → ((5 9)(6 8))

;; Sin recursividad:
(defn transponer [m] (apply map list m))
(defn aplicar-mascara [mascara lista]
  (reduce #(if (= (first %2) 1) (concat %1 (list (second %2))) %1)
          (conj (transponer (list mascara lista)) '())))
(defn sacar-columnas [matriz mascara]
  (let [tra (transponer matriz)]
    (aplicar-mascara
     (take (count tra) (flatten (repeat (quot (inc (count tra)) 2) mascara))) tra)))
(defn col-par-fil-imp [m]
  (if (empty? m) '() (sacar-columnas (sacar-columnas m '(0 1)) '(1 0))))
;; Con recursividad:
(defn sacar-impares [m]
  (if (or (empty? m) (empty? (rest m))) '()
      (cons (first m) (sacar-impares (rest (rest m))))))
(defn sacar-pares [f]
  (if (or (empty? f) (empty? (rest f))) '()
      (cons (second f) (sacar-pares (rest (rest f))))))
(defn col-par-fil-imp [m]
  (if (empty? m) '() (sacar-impares (map sacar-pares m))))