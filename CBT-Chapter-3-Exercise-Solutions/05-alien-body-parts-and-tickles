(ns alien-body-parts.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "This has been the alien model from exercise 5 in chapter 3! Goodbye!"))

(println "Commence the Alien Model Building!")
;; Vector of maps with part of the body
(def asym-alien-body-parts [{:name "head" :size 3}
                            {:name "left-eye" :size 1}
                            {:name "left-ear" :size 1}
                            {:name "mouth" :size 1}
                            {:name "nose" :size 1}
                            {:name "neck" :size 2}
                            {:name "left-shoulder" :size 3}
                            {:name "left-upper-arm" :size 3}
                            {:name "chest" :size 10}
                            {:name "back" :size 10}
                            {:name "left-forearm" :size 3}
                            {:name "abdomen" :size 6}
                            {:name "left-kidney" :size 1}
                            {:name "left-hand" :size 2}
                            {:name "left-knee" :size 2}
                            {:name "left-thigh" :size 4}
                            {:name "left-lower-leg" :size 3}
                            {:name "left-achilles" :size 1}
                            {:name "left-foot" :size 2}])
;; Multiplying matching part function
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(defn rock-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "rock-")
   :size (:size part)})
(defn paper-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "paper-")
   :size (:size part)})
(defn scissor-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "scissor-")
   :size (:size part)})
(println "Using better symmetrize now!")
;; Better symmetize with reduce built-in function
(defn better-symmetrize-body-parts
  "This function will process maps which have a :name and :size as keywords!"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part) (rock-part part) (paper-part part) (scissor-part part)])))
          []
          asym-body-parts))
(println "Calling symmetrize function!")
;; Calling better symmetrize function
(better-symmetrize-body-parts asym-alien-body-parts)
;; Announcing end of model building
(println "Alien Model Complete!")
;; Tickle the Alien
(defn tickle
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))
;; Trying out the tickles
(println "Commence tickle test!")
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println (tickle asym-alien-body-parts))
(println "Tickle test complete! Thank you for you cooperation, Alien!")