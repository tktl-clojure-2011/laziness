(ns laziness.core
  (:use [clojure.java.io :only (reader as-url)]))

(defn url-get [url]
  (with-open [in (reader (as-url url))]
    (doall (line-seq in))))

(defn counting-spider [urls]
  ":(")

(defn print-squares [up-to]
  ":(")
