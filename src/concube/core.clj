(ns concube.core)


(def square1
  [[1 2 3 4 5]
   [2 4 6 8 10]
   [1 3 5 7 9]
   [1 1 1 1 1]
   [0 2 0 0 0]])

(def concurrently true)

(defn row-sum-thread
  "Starts and returns a new thread calculating the sum of the row"
  [row]
  (future (reduce + row)))

(defn horizontal-sums-conc
  "Calculates the sum of the row in the current thread"
  [square]
  (let [futs (map row-sum-thread square)]
    (map deref futs)))

(defn horizontal-sums-serial
  "Calculates the sum of the row in the current thread"
  [square]
  (map #(reduce + %) square))

(defn horizontal-sums
  [square]
  (if concurrently
    (horizontal-sums-conc square)
    (horizontal-sums-serial square)))

(defn vertical-sums-conc
  [square]
  (let [rebuilt (apply map vector square)
        futs (map row-sum-thread rebuilt)]
    (map deref futs)))

(defn vertical-sums-serial
  [square]
  (apply map + square))

(defn vertical-sums
  [square]
  (if concurrently
    (vertical-sums-conc square)
    (vertical-sums-serial square)))

(defn println-square
  [square]
  (map println square))

(defn concube
  [square]
  (do
    (println "Square to print" square)
    (println-square square)))

(defn -main
  []
  (concube square1))
