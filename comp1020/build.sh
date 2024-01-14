#!/bin/bash

PUSH_FILES=0
BROWSER="brave-browser"

usage="Usage: build [-p|-c]
  -p: Push files to course website
  -c: Clean up generated files (e.g. *.html, *.pdf, *.class)
  [default: Generate HTML files for all lectures]"

function del_generated_files() {
  find -name "*.html" -not -path '*reveal.js*' -ls -delete
  find -name "*.pdf" -not -path '*reveal.js*' -ls -delete
  find -name "*.class" -not -path '*reveal.js*' -delete
}

# Analysing User Input
while getopts ":pc" opt; do
  case ${opt} in
  p)
    PUSH_FILES=1
    echo "Generating PDF version of slides and pushing files to server"
    ;;
  c)
    echo "Cleaning up generated files"
    del_generated_files
    exit 0
    ;;
  \?)
    echo $usage
    exit 1
    ;;
  esac
done

# Convering all Markdown files for every lecture to HTML
for x in $(find -name "index.md" -not -path '*reveal.js*'); do
  pushd $(dirname $x)
  PDF="$(basename $x .md).pdf"
  HTML="$(basename $x .md).html"

  # Markdown to HTML using pandoc
  pandoc -t revealjs -f markdown -s $(basename $x) -o $HTML -V theme=serif -i -V slideNumber=true -V history=true --slide-level=1 -V zoomKey="shift" \
    -V previewLinks=true -f markdown+emoji+fancy_lists -V revealjs-url=../../resources/reveal.js/ --katex --css ../../resources/style.css

  # Refresh browser to display changes in open HTML file
  for x in $(xdotool search --onlyvisible --class $BROWSER); do
    name=$(xdotool getwindowname $x)

    if [[ $name == *"Introductory Computer Science 2"* ]]; then
      xvkbd -window ${x} -text "\Cr" &>/dev/null
    fi
  done

  # Convert all HTMLs to PDFs as we are getting ready to upload to course website
  if [ $PUSH_FILES -ne 0 ]; then
    # HTML to PDF using Chrome
    $BROWSER --headless --disable-gpu --print-to-pdf=$PDF file://$(pwd)/$HTML?print-pdf &>/dev/null
  fi

  popd
done

# Upload all lecture PDFs to the course website
if [ $PUSH_FILES -ne 0 ]; then

  # Generate the directory structure
  python links.py >links.json

  # Push files to course webpage so students can view.
  rsync -zaurvm --chmod=o+rx --progress --include="*/" --include="index.pdf" \
    --include="*.java" --include="examples/*.txt" --include="links.json" --exclude="*" ./* linuxlab:~/public_html/comp1020/

  rm links.json
fi
