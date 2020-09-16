;; 34. Definir una función que reciba un número n y devuelva un vector de vectores que tenga la siguiente forma: [[1] [1 2] [1 2 3] [1 2 3 4] ... [1 2 3 4 ... n]]

(defn triang [n] (mapv #(vec (range 1 (inc %))) (range 1 (inc n))))