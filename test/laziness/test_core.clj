(ns laziness.test-core
  (:use laziness.core
        midje.sweet)
  (:import [java.io StringWriter]))

(defmacro capturing-output [f]
  `(let [output# (StringWriter.)
         ret# (binding [*out* output#]
                ~f)]
     [ret# (str output#)]))

(facts "counting-spider"
       (let [base "http://cs.helsinki.fi/u/ivacklin/"
             url-for-n (fn [n] (str base "clojure-" n ".txt"))
             urls (map url-for-n [0 1 2])]
         (capturing-output
           (counting-spider urls))
             => [[0 1 2]
                 (apply str (map #(str "Fetching " % "\n") urls))]))
