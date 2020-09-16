;; 2. Definir la función repartir que, llamada sin argumentos, devuelva la cadena "Uno para vos, uno para mí" . 
;; De lo contrario, se devolverá una lista, en la que habrá una cadena "Uno para X, uno para mí" por cada argumento X.

(defn repartir
  ([] (repartir "vos"))
  ([& more] (map #(str "Uno para " % ", uno para mí") more)))