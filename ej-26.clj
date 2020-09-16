;; 26. Definir la función sublist que devuelva la sublista correspondiente a una lista, una posición inicial y una longitud dadas. 
;; Por ejemplo: (sublist '(A B C D E F G) 3 2) → (C D)

;; Sin recursividad:
(defn sublist [lista posicion longitud] (take longitud (drop (dec posicion) lista)))
;; Con recursividad:
(defn sublist [lista posicion longitud]
  (cond
    (empty? lista) lista
    (zero? longitud) '()
    (> posicion 1) (sublist (rest lista) (dec posicion) longitud)
    true (cons (first lista) (sublist (rest lista) posicion (dec longitud)))))