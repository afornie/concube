(ns concube.t_core
  (:use midje.sweet)
  (:require [concube.core :refer :all]
            [clojure.test :refer :all]))


(deftest cloverage-wrapper-1
  (fact "Sum horizontally"
    (horizontal-sums [[1 2 3][2 4 6][1 0 0]]) => [6 12 1]
    )
)


(deftest cloverage-wrapper-2
  (fact "Sum horizontally in N threads"
    (horizontal-sums-conc [[1 2 3][2 4 6][1 0 0]]) => [6 12 1]
    )
)


(deftest cloverage-wrapper-3
  (fact "Sum horizontally in one thread"
    (horizontal-sums-serial [[1 2 3][2 4 6][1 0 0]]) => [6 12 1]
    )
)

(deftest cloverage-wrapper-4
  (fact "Sum vertically"
    (vertical-sums [[1 2 1][2 4 0][3 6 0]]) => [6 12 1]
    )
)

(deftest cloverage-wrapper-5
  (fact "Sum vertically in N threads"
    (vertical-sums-conc [[1 2 1][2 4 0][3 6 0]]) => [6 12 1]
    )
)

(deftest cloverage-wrapper-6
  (fact "Sum vertically in 1 thread"
    (vertical-sums-serial [[1 2 1][2 4 0][3 6 0]]) => [6 12 1]
    )
)
