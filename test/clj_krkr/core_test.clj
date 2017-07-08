(ns clj-krkr.core-test
  (:require [clojure.test :refer :all]
            [clj-krkr.core :refer :all]
            [clj-krkr.lines :refer :all]))

(deftest a-test
  (testing "Tests strip line"
    (is 
      (= 
        (strip-line "@bgm09【カナのテーマ】") 
        ""))
    (is 
      (= 
        (strip-line "すると、廊下の向こうから未羽が歩いてきた。友達と一緒だ。") 
        "すると、廊下の向こうから未羽が歩いてきた。友達と一緒だ。"))
    (is 
      (= 
        (strip-line "名前は[一ノ瀬,いち,の,せ]") 
        "名前は[一ノ瀬,いち,の,せ]"))
    (is 
      (= 
        (strip-line "【アルファ】「……元々アルファがニオイを察知して引き合わせたサンプルですが、正直言って恋が形作られているのか疑問ですね」") 
        "「……元々アルファがニオイを察知して引き合わせたサンプルですが、正直言って恋が形作られているのか疑問ですね」"))
    (is
      (=
        (strip-line ";◆ＢＧＭ：lista018(情景03「ar伝わってるよ」)《情景03(しんみりあったか)》")
        ""))
    (is
      (=
        (strip-line "[真理歩 voice=a06_00448]")
        ""))))
