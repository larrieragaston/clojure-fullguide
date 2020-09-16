;; 12. Definir una función para obtener la matriz triangular superior (incluye la diagonal principal) de una matriz cuadrada que está representada como una lista de listas.

;; Sin recursividad, dos funciones:
(defn map-matrices [f m1 m2] (map #(map f %1 %2) m1 m2))
(defn mat-triangular [m]
  (let [dim (count m)]
    (map-matrices * m (map #(concat (repeat % 0) (repeat (- dim %) 1)) (range dim)))))
;; Sin recursividad, una única función:
(defn mat-triangular [m]
  (let [dim (count m)]
    (map #(map * %1 %2) m (map #(concat (repeat % 0) (repeat (- dim %) 1)) (range dim)))))
;; Con recursividad:
(defn mat-triangular
  ([m] (mat-triang m 0 (count m)))
  ([m i n] (if (empty? m) m
               (cons (concat (repeat i 0) (drop i (first m)))
                     (mat-triangular (rest m) (inc i) n)))))
