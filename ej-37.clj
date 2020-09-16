;; 37. Definir una función que reciba una lista de pares ordenados, en los cuales la primera componente indica el equipo que resultó ganador de un partido y la segunda indica el
;; perdedor (no hay empates), y que devuelva una lista que contenga tres sublistas: en la primera, los equipos que ganaron más veces de las que perdieron; en la segunda, los
;; equipos que perdieron más veces de las que ganaron; y en la tercera, los equipos que ganaron y perdieron la misma cantidad de veces.

(defn transponer [m] (apply map list m))
(require '[clojure.set :refer [union]])
(defn list-eq [lista]
  (into (list) (apply union (map set (transponer lista)))))
(defn vict [lista] (first (transponer lista)))
(defn derr [lista] (second (transponer lista)))
(defn coinciden [a b] (if (= a b) 1 0))
(defn distl [dato lista] (map list (repeat (count lista) dato) lista))
(defn distr [lista dato] (map list lista (repeat (count lista) dato)))
(defn contar [lista]
  (list (ffirst lista) (apply + (map #(coinciden (first %) (second %)) lista))))
(defn cant-vict [lista]
  (map contar (map #(distl (first %) (second %)) (distr (list-eq lista) (vict lista)))))
(defn cant-derr [lista]
  (map contar (map #(distl (first %) (second %)) (distr (list-eq lista) (derr lista)))))
(defn mas-vict [lista]
  (if (> (second (first lista)) (second (second lista))) (ffirst lista) '()))
(defn mas-ganaron [lista]
  (filter symbol? (map mas-vict (transponer (list (cant-vict lista) (cant-derr lista))))))
(defn mas-derr [lista]
  (if (< (second (first lista)) (second (second lista))) (ffirst lista) '()))
(defn mas-perdieron [lista]
  (filter symbol? (map mas-derr (transponer (list (cant-vict lista) (cant-derr lista))))))
(defn vict-igual-derr [lista]
  (if (= (second (first lista)) (second (second lista))) (ffirst lista) '()))
(defn ganaron-igual-perdieron [lista]
  (filter symbol? (map vict-igual-derr (transponer (list (cant-vict lista) (cant-derr lista))))))
(defn clasificar [lista]
  (list (mas-ganaron lista) (mas-perdieron lista) (ganaron-igual-perdieron lista)))