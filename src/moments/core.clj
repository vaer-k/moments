(ns moments.core)

(def k (atom 0))
(def M (atom 0))
(def SS (atom 0))


(defn inc-mean [x]
  (+ @M (* (- x @M) (/ 1 @k))))

(defn inc-ss [x m]
  (+ @SS (* (- x m) (- x @M))))

(defn update [x]
  (let [m @M]
    (reset! k (inc @k))
    (reset! M (inc-mean x))
    (reset! SS (inc-ss x m)))
  nil)

(defn clear []
  (reset! k 0)
  (reset! M 0)
  (reset! SS 0)
  nil)
