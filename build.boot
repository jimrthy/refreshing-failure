(def project 'refreshing-failure)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test" "dev-resources"}
          :dependencies   '[[org.apache.logging.log4j/log4j-core "2.8.2" :scope "test"]
                            [org.apache.logging.log4j/log4j-1.2-api "2.8.2" :scope "test"]
                            [org.clojure/clojure "RELEASE"]
                            [org.clojure/tools.logging "0.4.0"]
                            [adzerk/boot-test "RELEASE" :scope "test"]
                            [samestep/boot-refresh "0.1.0"]])

(task-options!
 aot {:namespace   #{'refreshing-failure.core}}
 pom {:project     project
      :version     version
      :description "FIXME: write description"
      :url         "http://example/FIXME"
      :scm         {:url "https://github.com/yourname/refreshing-failure"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}}
 jar {:main        'refreshing-failure.core
      :file        (str "refreshing-failure-" version "-standalone.jar")})

(require '[samestep.boot-refresh :refer (refresh)])

(deftask build
  "Build the project locally as a JAR."
  [d dir PATH #{str} "the set of directories to write to (target)."]
  (let [dir (if (seq dir) dir #{"target"})]
    (comp (aot) (pom) (uber) (jar) (target :dir dir))))

(deftask run
  "Run the project."
  [a args ARG [str] "the arguments for the application."]
  (require '[refreshing-failure.core :as app])
  (apply (resolve 'app/-main) args))

(require '[adzerk.boot-test :refer [test]])
