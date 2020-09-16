;; 1. Definir la función digs que reciba un número y devuelva una lista con sus dígitos.

;; Convirtiendo el argumento en una cadena, sin Java, sin recursividad:
(defn digs [x] (if (neg? x)
                 (map {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9} (str (- x)))
                 (map {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9} (str x))))

;; Convirtiendo el argumento en una cadena, con Java, sin recursividad:
(defn digs [x] (map #(Character/digit % 10) (str (Math/abs x))))

;; Utilizando funciones aritméticas, con Java, sin recursividad:
(defn digs [x] (if (zero? x)
                 '(0)
                 (let [n (Math/abs x)]
                   (map #(rem (quot n %) 10)
                        (map #(int (Math/pow 10 %))
                             (range (int (Math/log10 n)) -1 -1))))))

;; Utilizando funciones aritméticas, sin Java, con función auxiliar recursiva, con reverse:
(defn aux-digs [x] (if (pos? x)
                     (conj (aux-digs (quot x 10)) (rem x 10))
                     nil))
(defn digs [x] (cond
                 (zero? x) '(0)
                 (pos? x) (reverse (aux-digs x))
                 true (reverse (aux-digs (- x)))))

;; Utilizando funciones aritméticas, sin Java, con función auxiliar recursiva, sin reverse:
(defn aux-digs [x] (if (pos? x)
                     (conj (aux-digs (quot x 10)) (rem x 10))
                     (clojure.lang.PersistentQueue/EMPTY)))
(defn digs [x] (cond
                 (zero? x) '(0)
                 (pos? x) (seq (aux-digs x))
                 true (seq (aux-digs (- x)))))