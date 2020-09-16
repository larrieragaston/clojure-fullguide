;; 23. Definir una función que devuelva true si una frase es un pangrama (es decir, si contiene todas las letras del alfabeto); si no, false. 
;; Por ejemplo: (pangrama? "Fabio me exige, sin tapujos, que añada cerveza al whisky") → true

(defn mayusculas-sin-acentos [cadena]
  (applystr (replace {\á "A",\é "E",\í "I",\ó "O",\ú "U",\ü "U",\ñ "Ñ",\Á "A",\E "E",\Í "I",\Ó "O",\Ú "U",\Ü "U"}
                     (map #(if (neg? (.indexOf "ÁÉÍÓÚÜÑáéíóúüñ" (str %))) (.toUpperCase (str %)) %) cadena))))
(defn pangrama? [frase]
  (= 27 (count (frequencies (re-seq #"[A-ZÑ]" (mayusculas-sin-acentos frase))))))
