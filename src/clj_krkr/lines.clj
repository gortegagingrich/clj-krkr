(ns clj-krkr.lines)
(require '[clojure.string :as str])

(def filters
  [#"\[[^'^,^\]]+\]" #"^@.*" #"^\;.*" #"【.*】"])

(defn strip-line
  ([line] 
    (strip-line line filters))
  ([line res]
    (if 
      (= (count res) 0)
      line
      (strip-line
        (str/replace line (first res) "")
        (subvec res 1)))))

(defn count-lines [fPath]
  (println fPath))