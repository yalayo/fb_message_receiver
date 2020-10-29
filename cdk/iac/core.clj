(ns iac.core
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [stedi.cdk.alpha :as cdk]
            [uberdeps.api :as uberdeps]))

(cdk/import [[App Construct Duration Stack] :from "@aws-cdk/core"]
            [[Code Function Runtime Tracing] :from "@aws-cdk/aws-lambda"])

(def app (App))

(def stack (Stack app "x-lambda"))

(def my-fn
  (Function stack
            "x-fn"
            {:code        (Code/fromAsset "example.zip")
             :handler     "pkg.Handler"
             :runtime     (:PROVIDED Runtime)
             :memorySize 128
             :timeout (Duration/seconds 30)
             }))
