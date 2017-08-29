(ns refreshing-failure.core-test
  (:require [clojure.test :refer :all]
            [refreshing-failure.core :as core]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 4 (core/xyz 1)))
    (comment
      (is (core/xyz1) 'broken))))
