;; 8. Definir una función para eliminar los elementos repetidos de una lista simple.

;; Sin recursividad:
(defn elim-rep [li]
  (reduce #(if (not= (.indexOf %1 %2) -1) %1 (concat %1 (list %2))) (conj li '())))
;; Con recursividad:
(defn elim-rep
  ([li] (elim-rep li '()))
  ([li tachito] (cond
                  (empty? li) tachito
                  (not= (.indexOf tachito (first li)) -1) (elim-rep (rest li) tachito)
                  true (elim-rep (rest li) (concat tachito (list (first li)))))))