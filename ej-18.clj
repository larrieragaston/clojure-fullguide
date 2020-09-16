;; 18. Definir una función que determine si una palabra tiene o no letras repetidas.

(defn mayusculas-sin-acentos [cadena]
  (applystr (replace {\á "A",\é "E",\í "I",\ó "O",\ú "U",\ü "U",\ñ "Ñ",\Á "A",\E "E",\Í "I",\Ó "O",\Ú "U",\Ü "U"}
                     (map #(if (neg? (.indexOf "ÁÉÍÓÚÜÑáéíóúüñ" (str %))) (.toUpperCase (str %)) %) cadena))))
(defn letras-repetidas? [p] (not (apply distinct? (map char (mayusculas-sin-acentos p)))))