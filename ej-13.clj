;; 13. Definir una función para obtener la diagonal principal de una matriz cuadrada que está representada como una lista de listas.

;; Sin recursividad:
(defn diagonal-ppal [m] (map #(nth (nth m %) %) (range (count m))))
;; Con recursividad:
(defn diagonal-ppal [m]
  (if (empty? m) m
      (cons (ffirst m) (diagonal-ppal (map rest (rest m))))))