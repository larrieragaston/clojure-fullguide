;; 9. Definir una función para ordenar una lista de listas por longitud creciente.

(defn longitud [x] (if (coll? x) (count x) 0))
(defn ordenar-nivel [li] (if (coll? li) (sort-by longitud li) li))
(defn ordenar [li] (if (coll? li) (map ordenar (ordenar-nivel li)) li))