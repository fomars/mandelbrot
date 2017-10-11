(ns mandelbrot.core-test
  (:require [clojure.test :refer :all]
            [mandelbrot.core :refer :all])
              (:import (mandelbrot.core Complex)))

(deftest test-compute-point
  (testing "compute point"
    (is (= (compute-point (Complex. -1 0) 2) nil))
           (is (= (compute-point (Complex. 1 0) 5) 2))
           (is (= (compute-point (Complex. 0.4 0.2) 5) nil))))

(deftest test-complex-arithmetic
  (testing "complex arithmetic"
           (testing "addition"
                    (is (=
                         (plus (Complex. 1 1) (Complex. 1 -1))
                         (Complex. 2M 0M)))
                    (is (=
                         (plus (Complex. 5 3) (Complex. -1 8))
                         (Complex. 4M 11M))))
           (testing "multiplication"
                    (is (=
                         (times (Complex. 1 1) (Complex. 1 -1))
                         (Complex. 2M 0M))))
           (testing "absolute value")
           (is (=
                (abs (Complex. 3 4))
                5))
           (is (=
                (abs (Complex. 13 8))
                15.264337522473747))
           ))

(deftest test-mandelbrot
  (testing "single mandelbrot function iteration"
           (is (=
                (mandelbrot (Complex. -0.1M 0.1M) (Complex. 0 0))
                (Complex. 0M -0.02M))))
  (testing "escape criterion"
           (is (=
                 false
                (escapes? (Complex. 0.5 1))))
           (is (=
                true
                (escapes? (Complex. -1.5 1.4))))))