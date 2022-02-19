#!/bin/bash

repl(){
  clj \
    -J-Dclojure.core.async.pool-size=1 \
    -X:repl Ripley.core/process \
    :main-ns Tamatoa.main
}

main(){
  clojure \
    -J-Dclojure.core.async.pool-size=1 \
    -M -m Tamatoa.main
}

uberjar(){

  clojure \
    -X:identicon Zazu.core/process \
    :word '"Tamatoa"' \
    :filename '"out/identicon/icon.png"' \
    :size 256

  rm -rf out/*.jar
  clojure \
    -X:uberjar Genie.core/process \
    :main-ns Tamatoa.main \
    :filename "\"out/Tamatoa-$(git rev-parse --short HEAD).jar\"" \
    :paths '["src" "out/identicon"]'
}

release(){
  uberjar
}

"$@"