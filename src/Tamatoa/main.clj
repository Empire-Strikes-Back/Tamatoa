(ns Tamatoa.main
  (:gen-class)
  (:require
   [clojure.core.async :as a :refer [<! >! <!! >!! chan put! take! go alt! alts! do-alts close! timeout pipe mult tap untap
                                     pub sub unsub mix admix unmix dropping-buffer sliding-buffer pipeline pipeline-async to-chan! thread]]
   [clojure.string]
   [clojure.java.io :as io]

   [Tamatoa.seed]
   [Tamatoa.dried-apricots]
   [Tamatoa.cashews]
   [Tamatoa.bananas]
   [Tamatoa.salt]
   [Tamatoa.zucchinis]
   [Tamatoa.green-peas]
   [Tamatoa.groats])
  (:import
   (javax.swing JFrame WindowConstants ImageIcon)))

#_(println (System/getProperty "clojure.core.async.pool-size"))
(do (set! *warn-on-reflection* true) (set! *unchecked-math* true))

(defonce stateA (atom nil))
(def ^:dynamic jframe nil)

(defn window
  []
  (let [jframe (JFrame. "i just love free food - and you look like vegan food")]

    (when-let [url (io/resource "icon.png")]
      (.setIconImage jframe (.getImage (ImageIcon. url))))

    (doto jframe
      (.setDefaultCloseOperation WindowConstants/EXIT_ON_CLOSE)
      (.setSize 1600 1200)
      (.setLocation 1700 300)
      (.setVisible true))

    (alter-var-root #'Tamatoa.main/jframe (constantly jframe))

    nil))

(defn reload
  []
  (require
   '[Tamatoa.main]
   :reload))

(defn -main
  [& args]
  (let []
    (reset! stateA {})

    (window)))