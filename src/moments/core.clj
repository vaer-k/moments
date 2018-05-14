(ns moments.core)

(def n (atom 0)) ; num records
(def M (atom 0)) ; mean
(def SS (atom 0)) ; sum of square
(def sigma (atom 0)) ; standard deviation


(defn inc-mean [x]
  (+ @M (* (- x @M) (/ 1 @n))))

(defn inc-ss [x m]
  (+ @SS (* (- x m) (- x @M))))

(defn update [x]
  (let [m @M]
    (reset! n (inc @n))
    (reset! M (inc-mean x))
    (reset! SS (inc-ss x m)))
  nil)

(defn clear []
  (reset! n 0)
  (reset! M 0)
  (reset! SS 0)
  nil)
