#!/bin/bash

PARENT="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR=$(pwd)
WITH_PDF=0
RELOAD=

while getopts pr: opt; do
    case $opt in
        p)
            WITH_PDF=1
            ;;
        r)
            RELOAD=$OPTARG
            ;;
        *)
            show_help
            exit 1
            ;;
    esac
done

for x in $(find -name "index.md" -or -name "lecture.md" -not -path '*reveal.js*') ; do
    pushd $(dirname $x)
    PDF="$(basename $x .md).pdf"

    pandoc -t revealjs -f markdown+emoji -s $(basename $x) -o $(basename $x .md).html -V theme=serif -i -V slideNumber=true -V history=true --slide-level=1 -V zoomKey="shift" -V previewLinks=true -V revealjs-url=../resources/reveal.js/ --katex --css ../resources/style.css 

    if [ $WITH_PDF -ne 0 ] ; then
        docker run --rm -u `id -u`:`id -g` -v `pwd`:/pandoc dalibo/pandocker $x -t beamer -o $PDF -f markdown+emoji --pdf-engine=xelatex -V handout -V header-includes="\usepackage{xelatexemoji}" -V header-includes="\usepackage[labelformat=empty]{caption}" -V paper-size="letter" 
    fi

    if [ "$RELOAD" != "" ] ; then
        # from http://eradman.com/entrproject/scripts/reload-browser
        xdotool search --onlyvisible --class "$RELOAD" windowfocus key \
                --window %@ 'ctrl+r' || {
                1>&2 echo "unable to signal an application named \"$RELOAD\""
            }
    fi
    popd
done
