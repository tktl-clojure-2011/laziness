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

(facts "print-squares"
       (capturing-output
         (print-squares 4))
           => [nil (apply str (map #(str % "\n") [0 1 4 9]))])

(facts "super-composite"
       (super-composite 3)  => 6
       (super-composite 4)  => 12
       (super-composite 5)  => 60
       (super-composite 6)  => 60
       (super-composite 7)  => 420
       (super-composite 8)  => 840
       (super-composite 12) => 27720)
