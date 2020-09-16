;; 32. Definir una función que calcule la profundidad de una lista. 
;; Por ejemplo: (profundidad '((2 3)(3 ((7))) 5)) → 4

(defn profundidad [lista]
  (if (not (coll? lista)) 0
      (if (> (inc (profundidad (first lista))) (profundidad (next lista)))
        (inc (profundidad (first lista)))
        (profundidad (next lista)))))