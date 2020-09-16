;; 5. Definir una función para eliminar las ocurrencias de un dato escalar en una lista (a todo nivel).

(defn elim [dat li]
  (cond
    (empty? li) li
    (coll? (first li)) (cons (elim dat (first li)) (elim dat (rest li)))
    true (if (= dat (first li))
           (elim dat (rest li))
           (cons (first li) (elim dat (rest li))))))