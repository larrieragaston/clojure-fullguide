;; 38. Definir una función que devuelva true si una frase es un palíndromo (es decir, si se lee igual al derecho o al revés); si no, false. No se debe distinguir entre mayúsculas y
;; minúsculas, ni considerar los acentos. Los espacios y los signos de puntuación deben ignorarse. 
;; Por ejemplo: (palindromo? "La ruta nos aportó otro paso natural.") → true

(defn mayusculas-sin-acentos [cadena]
  (applystr (replace {\á "A",\é "E",\í "I",\ó "O",\ú "U",\ü "U",\ñ "Ñ",\Á "A",\E "E",\Í "I",\Ó "O",\Ú "U",\Ü "U"}
                     (map #(if (neg? (.indexOf "ÁÉÍÓÚÜÑáéíóúüñ" (str %))) (.toUpperCase (str %)) %) cadena))))
(defn palindromo? [frase]
  (let [filtrada (re-seq #"[A-ZÑ]" (mayusculas-sin-acentos frase))]
    (= filtrada (reverse filtrada))))