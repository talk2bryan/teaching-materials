#!/bin/bash

PUSH_FILES=0

usage="Usage: cmd [-p]"


while getopts ":p" opt; do
    case ${opt} in
        p )
            PUSH_FILES=1
            echo "Pushing files to server"
            ;;
        \? )
            echo $usage
            exit 1
            ;;
    esac
done

for x in $(find -name "index.md" -not -path '*reveal.js*'); do
    pushd $(dirname $x)
    PDF="$(basename $x .md).pdf"
    HTML="$(basename $x .md).html"

    
    pandoc -t revealjs -f markdown -s $(basename $x) -o $(basename $x .md).html -V theme=serif -i -V slideNumber=true -V history=true --slide-level=1 -V zoomKey="shift" -V previewLinks=true -f markdown+emoji+fancy_lists -V revealjs-url=../../resources/reveal.js/ --katex --css ../../resources/style.css
    
    google-chrome --headless --disable-gpu --print-to-pdf=$PDF file://`pwd`/$HTML?print-pdf
    popd
done

if [ $PUSH_FILES -ne 0 ]; then
  python links.py > links.json
  rsync -zarvm --chmod=o+rx --progress --include="*/" --include="index.pdf" --include="*.java" --include="links.json" --exclude="*" ./* linuxlab:~/public_html/comp1020/
  
  rm links.json
fi


