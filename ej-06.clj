;; 6. Definir una función para obtener el último símbolo de una lista (a todo nivel) .

(defn ultimo-simbolo [li] (first (drop-while (comp not symbol?) (reverse (flatten li)))))