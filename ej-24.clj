;; 24. Definir la función narcissistic? que devuelva true si un número dado es igual a la suma de cada uno de sus dígitos elevado a la cantidad de dígitos; si no, false. 
;; Por ejemplo: (narcissistic? 153) → true

;; Con Java (falla para números grandes, por ejemplo: 21897142587612075):
(defn digs [x] (map #(Character/digit % 10) (str (Math/abs x))))
(defn narcissistic? [n]
  (let [digitos (digs n)]
    (== (Math/abs n) (reduce + (map #(Math/pow % (count digitos)) digitos)))))
;; Sin Java (funciona incluso con números grandes, por ejemplo: 21897142587612075):
(defn potencia [base exponente] (reduce * (repeat exponente base)))
(defn modulo [x] (if (neg? x) (- x) x))
(defn digs [x] (map {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9} (str (modulo x))))
(defn narcissistic? [n]
  (let [digitos (digs n)]
    (= (modulo n) (reduce + (map #(potencia % (count digitos)) digitos)))))