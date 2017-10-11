(ns mandelbrot.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defrecord Complex [^BigDecimal real ^BigDecimal imag])

(def zero (Complex. 0M 0M))

(defn plus [^Complex z1 ^Complex z2]
  (let [x1 (bigdec (.real z1))
        y1 (bigdec (.imag z1))
        x2 (bigdec (.real z2))
        y2 (bigdec (.imag z2))]
    (Complex. (+ x1 x2) (+ y1 y2))))

(defn times [^Complex z1 ^Complex z2]
  (let [x1 (bigdec (.real z1))
        y1 (bigdec (.imag z1))
        x2 (bigdec (.real z2))
        y2 (bigdec (.imag z2))]
    (Complex. (- (* x1 x2) (* y1 y2)) (+ (* x1 y2) (* y1 x2)))))

(defn abs [^Complex z]
  (let [x (bigdec (.real z))
        y (bigdec (.imag z))]
    (math/sqrt (+ (* x x) (* y y)))))

(defn belongs? [^Complex z]
      (<= (abs z) 0.25))

(defn escapes? [^Complex z]
  (> (abs z) 2))

(defn mandelbrot [^Complex z ^Complex c]
  (plus c (times z z)))

(defn mandelbrot-step [^Complex z ^Complex c ^Long current-step ^Long max-steps]
  (if (escapes? z)
    current-step
    (if (or (belongs? z) (>= current-step max-steps))
      nil
      (mandelbrot-step (mandelbrot z c)
                       c
                       (inc current-step)
                       max-steps)))
  )

(defn compute-point [^Complex c ^Long max-steps]
  (mandelbrot-step (mandelbrot zero c) c 0 max-steps))