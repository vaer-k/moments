(ns moments.core)

(def n (atom 0)) ; num records
(def M (atom 0)) ; mean
(def SS (atom 0)) ; sum of squares


(defn variance []
  (/ @SS (- @n 1)))

(defn std []
  (Math/sqrt (variance)))

(defn inc-mean [x m n]
  (-> (- x m)
      (/ (inc n))
      (+ m)))

(defn inc-ss [x ss old-m new-m]
  (-> (- x old-m)
      (* (- x new-m))
      (+ ss)))

(defn update [x]
  (let [old-m @M
        new-m (inc-mean x old-m @n)]
    (reset! n (inc @n))
    (reset! M new-m)
    (reset! SS (inc-ss x @SS old-m new-m)))
  nil)

(defn clear []
  (reset! n 0)
  (reset! M 0)
  (reset! SS 0)
  nil)
