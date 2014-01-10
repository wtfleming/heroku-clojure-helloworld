(defproject foo "0.1.0-SNAPSHOT"
  :description "Example of running clojure on heroku"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring "1.2.1"]
                 [hiccup "1.0.4"]]
  :min-lein-version "2.0.0"
  :main wtfleming.core)
