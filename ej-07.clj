;; 7. Definir una función para obtener el elemento central de una lista.

;; Sin recursividad:
(defn central [li]
  (let [len (count li) med (quot len 2)]
    (cond
      (zero? len) '()
      (odd? len) (nth li med)
      true (list (nth li (dec med)) (nth li med)))))
;; Con recursividad:
(defn central [li]
  (let [len (count li)]
    (cond
      (= len 1) (first li)
      (< len 3) li
      true (central (butlast (rest li))))))