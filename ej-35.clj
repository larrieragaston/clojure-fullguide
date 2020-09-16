;; 35. Definir una función que reciba una lista de pares ordenados, en los cuales la primera componente indica el equipo que resultó ganador de un partido y la segunda 
;; indica el perdedor (no hay empates), y que devuelva una lista con los equipos invictos.

(defn transponer [m] (apply map list m))
(require '[clojure.set :refer [difference]])
(defn invictos [lista]
  (into (list) (apply difference (map set (transponer lista)))))