(ns refreshing-failure.core
  (:require [clojure.tools.logging :as log])
  (:gen-class))

(set! *warn-on-reflection* true)

(defn usage!
  []
  (log/info "\nUsage: run.sh -f /path/to/files1 -f /path/to/files2 ... > output.csv"))

(defn xyz
  [n]
  (+ 3 n))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
