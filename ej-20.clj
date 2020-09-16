;; 20. Definir una función que reciba una palabra y un conjunto de sus posibles anagramas, y devuelva un conjunto que solo contenga las palabras que realmente son sus anagramas.

(defn mayusculas-sin-acentos [cadena]
  (applystr (replace {\á "A",\é "E",\í "I",\ó "O",\ú "U",\ü "U",\ñ "Ñ",\Á "A",\E "E",\Í "I",\Ó "O",\Ú "U",\Ü "U"}
                     (map #(if (neg? (.indexOf "ÁÉÍÓÚÜÑáéíóúüñ" (str %))) (.toUpperCase (str %)) %) cadena))))
(defn anagramas? [palabra-1 palabra-2]
  (let [p1 (mayusculas-sin-acentos palabra-1)
        p2 (mayusculas-sin-acentos palabra-2)]
    (and (not= p1 p2) (= (frequencies p1) (frequencies p2)))))
(defn filtrar-anagramas [palabra conjunto]
  (set (filter #(anagramas? % palabra) conjunto)))
