(ns clj-krkr.lines)
(require '[clojure.string :as str])
(use 'clojure.java.io)

(def filters
  [#"\[[^,^]+\]" #"^@.*" #"^\;.*" #"【.*】" #"^\*.*"])

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

(defn count-lines
  ([fPath]
    (count-lines 
      (str/split (slurp fPath) #"\n") 0))
  ([lines n]
    (if (> (count lines) 0)
      (if (> (count (strip-line (first lines))) 1)
        (count-lines (subvec lines 1) (+ n 1))
        (count-lines (subvec lines 1) n))
      n)))

(defn print-line [line]
  (if (> (count line) 1)
    (println line)))

(defn print-lines [fPath]
  (with-open [fin (reader fPath :encoding "JISAutoDetect")]
    (doseq [line (line-seq fin)]
      (print-line (strip-line line)))))
