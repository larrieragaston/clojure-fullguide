;; 19. Definir la función slice que reciba una cadena cad y un número n y devuelva una lista con todas las subcadenas contiguas de cad cuyo tamaño sea n. 
;; Por ejemplo: (slice "abcde" 3) → ("abc" "bcd" "cde")

(defn slice [cad n]
  (if (zero? n) nil (map #(apply str %) (partition n 1 cad))))
