;; 11. Definir la función b que aplicada a una lista de funciones f y a un argumento x obtenga la lista de resultados de aplicar cada función f a x.

;; Sin recursividad:
(defn b [f x] (map #(% x) f))
;; Con recursividad:
(defn b [f x] (if (empty? f) f (cons ((first f) x) (b (rest f) x))))
;; Ejemplo de uso:
;; user=> (b (list first rest count) '(a b c d e f g))
;; (a (b c d e f g) 7) 
