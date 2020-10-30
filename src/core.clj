(ns core
  (:require [main :as m])
  (:gen-class))
(defn -main [& args]
  (m/process_data args))
