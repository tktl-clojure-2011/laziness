(ns laziness.test-core
  (:use laziness.core
        midje.sweet)
  (:import [java.io StringWriter]))

(facts "counting-spider"
       (let [base "http://cs.helsinki.fi/u/ivacklin/"
             url-for-n (fn [n] (str base "clojure-" n ".txt"))
             urls (map url-for-n [0 1 2])
             output (StringWriter.)]
         (binding [*out* output]
           (counting-spider urls)) => [0 1 2]
         (str output) => (apply str (map #(str "Fetching " % "\n") urls))))

(facts "print-squares"
       )
