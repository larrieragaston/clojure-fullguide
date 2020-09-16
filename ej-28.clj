;; 28. Definir una función que actúe como la instrucción distl de FP. 
;; Por ejemplo: (distl 'a '(b c d)) → ((a b)(a c)(a d))

;; Sin recursividad:
(defn distl [dato lista] (map list (repeat (count lista) dato) lista))
;; Con recursividad:
(defn distl [dato lista]
  (if (empty? lista) lista
      (cons (list dato (first lista)) (distl dato (rest lista)))))