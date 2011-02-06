(ns laziness.core)

(defn url-get [url]
  (with-open [in (reader (as-url url))]
    (doall (line-seq in))))

(defn counting-spider [urls]
  ":(")
