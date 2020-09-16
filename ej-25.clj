;; 25. Definir las funciones filas-max-V y mas-V-o-F, que aplicadas a una matriz de V y F (representada como una lista de listas que contengan los valores V y F), devuelvan respectivamente:

;; a) El/los número/s de la/s fila/s en la/s que la cantidad de V es máxima, por ejemplo: (filas-max-V '((V F V V F)(V V F V V)(F F F V F)(V V V F V))) → (2 4)
(defn a-todos-en-matriz [funcion matriz] (map #(map funcion %) matriz))
(defn contar-V [matriz] (map #(apply + %) (a-todos-en-matriz '{V 1, v 1, F 0, f 0} matriz)))
(defn mas-V [matriz] (apply max (contar-V matriz)))
(defn mascara [matriz] (map #(if (= (mas-V matriz) %) 1 0) (contar-V matriz)))
(defn transponer [m] (apply map list m))
(defn aplicar-mascara [mascara lista]
  (reduce #(if (= (first %2) 1) (concat %1 (list (second %2))) %1)
          (conj (transponer (list mascara lista)) '())))
(defn filas-max-V [matriz] (aplicar-mascara (mascara matriz) (range 1 (inc (count matriz)))))

;; b) V si en la mayoría de las filas hay más V que F o, de lo contrario, F, por ejemplo: (mas-V-o-F '((V F V V F)(F F F V F)(V V F F V))) → V
(defn a-todos-en-matriz [funcion matriz] (map #(map funcion %) matriz))
(defn contar-V [matriz] (map #(apply + %) (a-todos-en-matriz '{V 1, v 1, F 0, f 0} matriz)))
(defn contar-F [matriz] (map #(apply + %) (a-todos-en-matriz '{V 0, v 0, F 1, f 1} matriz)))
(defn mas-V-o-F [matriz]
  (let [mapa (frequencies (map #(if (> %1 %2) :v :f) (contar-V matriz) (contar-F matriz)))]
    (if (> (mapa :v) (mapa :f)) 'V 'F)))