;; 22. Definir una función que reciba una cadena y devuelva el acrónimo que surge a partir de ella.

(defn mayusculas-sin-acentos [cadena]
  (applystr (replace {\á "A",\é "E",\í "I",\ó "O",\ú "U",\ü "U",\ñ "Ñ",\Á "A",\E "E",\Í "I",\Ó "O",\Ú "U",\Ü "U"}
                     (map #(if (neg? (.indexOf "ÁÉÍÓÚÜÑáéíóúüñ" (str %))) (.toUpperCase (str %)) %) cadena))))
(defn acronimo [cadena]
  (apply str (map first (re-seq #"[A-ZÑ]+" (mayusculas-sin-acentos cadena)))))