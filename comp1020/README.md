# COMP 1020

Tool for generating lecture content (HTML and PDF files) on a *nix system.

## Requirements
- pandoc
- python 2.7+
- xdotool
- rsync (Optional)

## Usage
```
build [-p|-c]
  -p: Push files to course website
  -c: Clean up generated files (e.g. *.html, *.pdf, *.class)
  [default: Generate HTML files for all lectures]"
```
