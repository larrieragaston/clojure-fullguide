;; 27. Definir la función pos-inicial que, dadas dos listas simples, devuelva la posición inicial en la cual la primera lista se encuentra contenida en la segunda. 
;; Si no se encuentra contenida, la función devolverá cero. Por ejemplo:
;; (pos-inicial '(C D) '(A B C D E F)) → 3
;; (pos-inicial '(A C) '(A B C D E F)) → 0

;; Sin recursividad:
(defn pos-inicial [lista-1 lista-2]
  (inc (.indexOf (partition (count lista-1) 1 lista-2) lista-1)))
;; Con recursividad:
(defn empieza-con [lista-1 lista-2]
  (= lista-1 (take (count lista-1) lista-2)))
(defn pos-inicial
  ([lista-1 lista-2] (pos-inicial lista-1 lista-2 1))
  ([lista-1 lista-2 p]
   (cond
     (empty? lista-2) 0
     (empieza-con lista-1 lista-2) p
     true (pos-inicial lista-1 (rest lista-2) (inc p)))))