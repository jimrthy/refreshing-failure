(ns refreshing-failure.core-test
  #_core-test
  (:require [clojure.test :refer :all]
            [refreshing-failure.core :as core]))

(deftest a-test
  (testing "Basic math"
    (is (= 5 (core/add-3 2)))))
