;; 14. Definir una función para transponer una lista de listas.

;; Sin recursividad:
(defn transponer [m] (apply map list m))
;; Con recursividad:
(defn transponer [m]
  (if (empty? (first m)) '()
      (cons (map first m) (transponer (map rest m)))))