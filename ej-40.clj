;; 40. Definir una función que reciba un número entero y devuelva una cadena con su representación en números romanos.

(defn a-romano [n]
  (if (or (< n 1) (> n 3999)) nil
      (-> (apply str (repeat n "I"))
          (clojure.string/replace #"IIIII" "V")
          (clojure.string/replace #"IIII" "IV")
          (clojure.string/replace #"VV" "X")
          (clojure.string/replace #"VIV" "IX")
          (clojure.string/replace #"XXXXX" "L")
          (clojure.string/replace #"XXXX" "XL")
          (clojure.string/replace #"LL" "C")
          (clojure.string/replace #"LXL" "XC")
          (clojure.string/replace #"CCCCC" "D")
          (clojure.string/replace #"CCCC" "CD")
          (clojure.string/replace #"DD" "M")
          (clojure.string/replace #"DCD" "CM"))))