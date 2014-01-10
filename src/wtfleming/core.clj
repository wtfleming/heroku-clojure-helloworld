(ns wtfleming.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.route :as route])
  (:use [hiccup.page :only (html5 include-js include-css)]
        [compojure.core :only (defroutes GET)]))

(defn index []
  (html5 {:ng-app ""}
    [:head
      [:title "Hello World App"]
      (include-js
        "https://ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.js")
      (include-css "/style.css")
]
    [:body
      [:input {:type "text" :ng-model "name" :placeholder "Your name"}]
      [:h1 "Hello {{name}}"]]))

(defroutes site-routes
  (GET "/" [] (index))
  (route/resources "/")
  (route/not-found "404 Not Found"))

(defn -main []
  (jetty/run-jetty site-routes {:port 5000 :join? false}))
