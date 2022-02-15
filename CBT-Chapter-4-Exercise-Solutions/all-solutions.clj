
;; CBT Chapter 4


(ns fwpd.core
	:require
	[clojure.string] :as string)

;; A Vampire Data Analysis Program for the FWPD

(defn -main [& args]
  (println "This is a message from the main function! Bye now!"))

(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
 [str]
 (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})
(defn convert
 [vamp-key value]
 ((get conversions vamp-key) value))

(convert :glitter-index "3")

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(first (mapify (parse (slurp filename))))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(println "Trying out the glitter filter now!")

(println (glitter-filter 3 (mapify (parse (slurp filename)))))

;; Solutions to the exercises

;; 1) Turn the result of your glitter filter into a list of names.

(println "Solution to exercise 1 coming now! Returning a lazy seq (list-like):")

(def suspects-list (map :name (glitter-filter 3 (mapify (parse (slurp filename))))))

(println suspects-list)

;; 2) Write a function, append, which will append a new suspect to your list of suspects.
;; I am not sure what exactly the exercise was asking. I feel that this solution is a bit off. For one, append can only add to one list, the one from exercise 1. Another problem is that no values for other records concerning the suspect are asked for here, the .csv file will not be changed, so all this is very much against the grain for me.

(println "Solution to exercise 2 coming now!")

(defn append
	[new-suspect]
	(cons new-suspect suspects-list))


(def new-list (append "Daniel Higginbotham"))
(println new-list)

;; 3) Write a function, validate, which will check that :name and :glitter-index are present when you append. The validate function should accept two arguments: a map of keywords to validating functions, similar to conversions, and the record to be validated.

(println "Solution to exercise 3 is not coming, because I have no idea how to build a function which would take the arguments mentioned for the purpose of validating. Next!")

(println "PS. I will come back to his after the meeting on Friday.")

;; 4) Write a function that will take your list of maps and convert it back to a CSV string. You’ll need to use the clojure.string/join function.

;; I think this solution is legit, but I keep running into namespace and require problems when I run the program in the repl. I get this:
;; Syntax error (ClassCastException) compiling at (fwpd/core.clj:90:1).
;; class java.lang.Character cannot be cast to class java.util.Map$Entry (java.lang.Character and java.util.Map$Entry are in module java.base of loader 'bootstrap')


(println "Solution to exercise 4 coming now!")

(defn map->csv [data]
  (->> data
     (map #(vals %))
     (map #(string/join "," %))
     (string/join "\n")))

(map->csv new-list)

(println (glitter-filter 3 (mapify (parse (slurp new-list)))))
