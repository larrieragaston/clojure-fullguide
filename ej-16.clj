;; 16. Definir una función que cuente las apariciones de cada palabra en una frase.

(defn mayusculas [cadena]
  (apply str (replace {\á "A", \é "E", \í "I", \ó "O", \ú "U", \ü "U", \ñ "Ñ"}
                      (map #(if (neg? (.indexOf "ÁÉÍÓÚÜÑáéíóúüñ" (str %))) (.toUpperCase (str %)) %) cadena))))
(defn contar-palabras [frase]
  (sort-by first (frequencies (re-seq #"[A-ZÁÉÍÓÚÜÑa-záéíóúüñ]+" (mayusculas frase)))))
