(ns wtfleming.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.route :as route]
            [compojure.handler :as handler])
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

(defroutes routes
  (GET "/" [] (index))
  (route/resources "/")
  (route/not-found "404 Not Found"))



(def application (handler/site routes))

(defn start [port]
  (jetty/run-jetty #'application {:port port :join? false}))

(defn -main []
  (let [port (Integer/parseInt
               (or (System/getenv "PORT") "5000"))]
  (start port)))
