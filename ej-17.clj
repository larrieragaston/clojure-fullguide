;; 17. Definir una función que devuelva el tipo de triángulo que constituyen tres números que representan longitudes.

;; Usando solo operaciones lógicas:
(defn tipo-de-triangulo [a b c]
  (cond
    (or (> a (+ b c)) (> b (+ c a)) (> c (+ a b))) :no-triangulo
    (or (= a (+ b c)) (= b (+ c a)) (= c (+ a b))) :degenerado
    (and (= a b) (= b c)) :equilatero
    (or (= a b) (= a c) (= b c)) :isosceles
    true :escaleno))
;; Usando operaciones lógicas, count y un vector como si fuera una función:
(defn tipo-de-triangulo [a b c]
  (cond
    (or (> a (+ b c)) (> b (+ c a)) (> c (+ a b))) :no-triangulo
    (or (= a (+ b c)) (= b (+ c a)) (= c (+ a b))) :degenerado
    true ([:equilatero :isosceles :escaleno] (dec (count (frequencies (list a b c)))))))
