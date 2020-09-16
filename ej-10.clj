;; 10. Un ISBN-10 es válido si sus 10 dígitos x1, x2, x3, ... x10 cumplen lo siguiente:
;; (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
;; Un ISBN-10 está dividido en cuatro partes: el código de país o lengua de origen (de 1 a 5 dígitos), el editor, 
;; el número del artículo y un dígito de control. Opcionalmente, estas cuatro partes pueden estar separadas mediante espacios en blanco o guiones.
;; El dígito de control puede valer X que representa el valor 10. Por ejemplo, 3-598-21507-X es un ISBN-10 válido. 
;; Escribir la función isbn-10? que devuelve true si la cadena recibida es un ISBN-10 válido; si no, false.

(defn formato-ok? [isbn]
  (if (not (string? isbn)) false
      (let [longitud-isbn (count isbn)
            cant-digitos (count (re-seq #"\d" isbn))
            cant-guiones (count (re-seq #"-" isbn))
            cant-espacios (count (re-seq #"\s" isbn))
            termina-en-x (= (.toUpperCase (str (last isbn))) "X")
            digs-ok (or (= cant-digitos 10) (and (= cant-digitos 9) termina-en-x))
            partes (re-seq #"[0-9X]+" isbn)
            cant-partes (count partes)
            long-pais (count (first partes))
            long-ctrl (count (last partes))]
        (cond (= longitud-isbn 10) digs-ok
              (= longitud-isbn 13)
              (and (or (= cant-guiones 3) (= cant-espacios 3))
                   digs-ok
                   (= cant-partes 4)
                   (and (pos? long-pais) (< long-pais 6))
                   (= long-ctrl 1))
              true false))))

(defn valor-ok? [lista-num]
  (zero? (mod (reduce + (map * (range 10 -1 -1) lista-num)) 11)))

(defn numeros [isbn]
  (filter number? (map {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9 \X 10} isbn)))

(defn isbn-10? [isbn]
  (and (formato-ok? isbn) (valor-ok? (numeros isbn))))
