# My Calculator

### Introduction/Purpose
  Purpose of this project is to use a new GUI API for myself - JavaFX -> https://openjfx.io/ while also retaining some of my Java skills from Undergraduate.

### Tools/Language Selection
  Making use of ItelliJ-IDEA for development. Java seemed like a nice refresher for myself. When it came to picking JavaFX I wanted to try out a different GUI library than AWT or Swing, which I've used in Undergraduate projects. It looks fresh and modern.

# Updates Section

### Undocumented Updates
Started off the project and created basic mathematical functions via *operations.basicOperations.java* which includes but is not limited to addition, subtraction, multiplication and so forth. More advanced basic Calculator functions are in *operations.advOperations.java* which includes but is not limited to square root, square, negative/positive, etc.

Created some basic junit testing for the operations. Not entirely sure how to handle testing GUI stuff at the moment...

### 2-4-2022
- Added advanced Operations
- Added support for using JavaFx
- Created screenshot directory for screenshots from development.
- made a basic gui test

Screenshot from testing...
![JavaFX Testing](screenshots/gui-test_2-4-2022.png)

### 2-6-2022
- Created logic to add number buttons
- Some of the issues I found were which pane I needed to use to get the buttons in a nice grid. Then needed to add a '.' and '+/-' for basic calculator functions. I am thinking I need to create a operation flip to adding into decimals.

![JavaFX Testing](screenshots/gui-test_2-6-2022.png)

### 2-10-2022
- Looked at tutorial(s) and information on how event handling works in JavaFX.
- Implemented basic event handling to button to add text to the new text area that resides at the top.

![JavaFX Testing](screenshots/gui-test_2-10-2022.png)

### 2-12-2022
- Added VERY basic arithmetic and changed how buttons are created/added.
- I ran into an issue where I needed to retain the current value in the text area after a function was pressed (ie: 34 + 3) then needing to concatenate onto that number vs. changing the number. I also added function to check if the number was 'whole' to retain whole numbers on screen when they are there... vs. doubles. 
