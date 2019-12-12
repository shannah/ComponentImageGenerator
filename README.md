# Component Image Generator

The project generates screenshots of each Codename one component for which there is a test, and compiles them in an HTML file.


## Requirements

Must have `ant` in your PATH, and `JAVA_HOME` should be set.

## Usage

~~~~
$ sh run.sh
~~~~

This will generate screenshots for both iOS and Android and place them in ~/.cn1/output directory, with an index file at ~/.cn1/output/index.html.