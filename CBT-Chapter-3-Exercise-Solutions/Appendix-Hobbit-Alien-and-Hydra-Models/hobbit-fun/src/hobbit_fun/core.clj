(ns hobbit-fun.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello! This message comes from the main function!"))

(println "Commence the Hobbit Model Building!")
;; Vector of maps with part of the body
(def asym-hobbit-body-parts [{:name "head" :size 3}
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
;; Matching part function
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
;; Symmetrize function: first version
;; (defn symmetrize-body-parts
;;   "Expects a seq of maps that have a :name and :size"
;;   [asym-body-parts]
;;   (loop [remaining-asym-parts asym-body-parts
;;          final-body-parts []]
;;     (if (empty? remaining-asym-parts)
;;       final-body-parts
;;       (let [[part & remaining] remaining-asym-parts]
;;         (recur remaining
;;                (into final-body-parts
;;                      (set [part (matching-part part)])))))))
;; Better symmetize with reduce built-in function
(defn better-symmetrize-body-parts
  "This function will process maps which have a :name and :size as keywords!"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))
;; Calling symmetrize-body-parts function: (symmetrize-body-parts asym-hobbit-body-parts)
;; Calling better symmetrize function
(better-symmetrize-body-parts asym-hobbit-body-parts)
;; Announcing end of model building
(println "Hobbit Model Complete!")
;; Tickle the Hobbit
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
(println (tickle asym-hobbit-body-parts))
(println (tickle asym-hobbit-body-parts))
(println (tickle asym-hobbit-body-parts))
(println (tickle asym-hobbit-body-parts))
(println (tickle asym-hobbit-body-parts))
(println "Tickle test complete!")