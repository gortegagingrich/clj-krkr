(ns clj-krkr.lines)
(require '[clojure.string :as str])

(def fmt #"[\[^\]*]")
(def cmd #"^@.*")
(def cmt #"^\;.*")
(def spk #"【.*】")

(defn strip-line [line]
  (str/join
    (str/split 
      (str/join 
        (str/split 
          (str/join
            (str/split 
              (str/join
                (str/split line spk))
              cmt)) 
          cmd)) 
      fmt)))

(defn count-lines [fPath]
  (println fPath))