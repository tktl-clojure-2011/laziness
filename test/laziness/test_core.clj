(ns laziness.test-core
  (:use laziness.core
        midje.sweet))

(facts "counting-spider"
       (let [base "http://cs.helsinki.fi/u/ivacklin/"
             url-for-n (fn [n] (str base "clojure-" n ".txt"))
             urls (map url-for-n [0 1 2])]
         (counting-spider urls) => [0 1 2]))
