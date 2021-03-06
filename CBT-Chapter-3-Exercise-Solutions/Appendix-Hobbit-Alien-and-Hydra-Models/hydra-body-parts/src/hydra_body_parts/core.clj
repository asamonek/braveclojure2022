(ns hydra-body-parts.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "This has been the hydra model from exercise 6 in chapter 3! Goodbye!"))

(println "Commence the Hydra Model Building!")
(def hydra-body-parts [{:name "head" :size 3}
                       {:name "eye-1" :size 1}
                       {:name "ear-1" :size 1}
                       {:name "mouth" :size 1}
                       {:name "nose" :size 1}
                       {:name "neck" :size 2}
                       {:name "shoulder-1" :size 3}
                       {:name "upper-arm-1" :size 3}
                       {:name "chest" :size 10}
                       {:name "back" :size 10}
                       {:name "forearm-1" :size 3}
                       {:name "abdomen" :size 6}
                       {:name "kidney-1" :size 1}
                       {:name "hand-1" :size 2}
                       {:name "knee-1" :size 2}
                       {:name "thigh" :size 4}
                       {:name "lower-leg-1" :size 3}
                       {:name "achilles-1" :size 1}
                       {:name "foot-1" :size 2}])
;; This matching function is based on a solution by madmax96: https://github.com/madmax96/brave-clojure-solutions/blob/master/section_3.clj
;; The names of the body parts were also changed to match this function's syntax
(defn matching-hydra-parts
  [{name :name size :size} n]
  (reduce (fn [all-parts n] (conj
                             all-parts
                             {:size size :name (clojure.string/replace name #"-(.*)" (str "-" n))}))
          #{}
          (range 1 (inc n))))
(println "Symmetrize function comes to life here!")
(defn symetrize-hydra-body-parts
  "This function allows for creating n body parts for any n in N."
  [hydra-body-parts n]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (matching-hydra-parts part n)))
          []
          hydra-body-parts))
(println "Calling a 10-ary symmertize function!")
(symetrize-hydra-body-parts hydra-body-parts 10)
(println "I will now try to make the Hydra ticklish!")
;; Tickle the Hydra
(defn tickle
  [asym-body-parts]
  (let [sym-parts (symetrize-hydra-body-parts hydra-body-parts 10)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))
;; Trying out the tickles
(println "Commence tickle test!")
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println (tickle hydra-body-parts))
(println "Tickle test complete! Thank you for you cooperation, Hydra!")