(defproject mandelbrot "0.1.0-SNAPSHOT"
  :description "library and app for computing mandelbrot set"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot mandelbrot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
