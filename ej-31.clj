;; 31. Definir una función que devuelva la lista que resulta al intercalar los elementos de otras dos listas que recibe como parámetros. 
;; Por ejemplo: (intercalar '(1 2 3) '(4 5 6)) → (1 4 2 5 3 6)

;; Sin recursividad:
(defn intercalar [lista-1 lista-2] (flatten (map list lista-1 lista-2)))
;; Con recursividad:
(defn intercalar [lista-1 lista-2]
  (cond (empty? lista-1) lista-2
        (empty? lista-2) lista-1
        true (concat (list (first lista-1) (first lista-2))
                     (intercalar (rest lista-1) (rest lista-2)))))