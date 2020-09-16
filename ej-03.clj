;; 3. Definir una función para producir una lista con los elementos en las posiciones pares de dos listas dadas.

(defn pos-pares [L] (map second (partition 2 L)))
(defn pares-de-2-listas [L1 L2] (concat (pos-pares L1) (pos-pares L2)))