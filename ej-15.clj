;; 15. Definir una función que cuente las apariciones de cada nucleótido en una cadena de ADN.

(defn contar-nucleotidos [adn]
  (let [up-adn (.toUpperCase adn)]
    (if (not-every? #(not= (.indexOf "GCTA" (str %)) -1) up-adn)
      nil
      (frequencies (map str up-adn)))))
