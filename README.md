# CovidVisualizer

Project that takes data about Covid 19 and displays it on a GUI
•	Displayed Case Fatality Ratio (CFR) through a GUI that created a Histogram Chart from regions with the lowest CFR to highest CFR or by alphabetical order
•	Parsed data from text files and csv from Covid-19 cases reported from the CDC
•	Used data structures such as Doubly Linked List and implemented comparators to organize the data

Implemented Comparators for CFR and Alpha so that we can determine which comes first on the GUI

Ethnicity class has fields of name, cases, and deaths, and is used for tracking the amount of covid cases per ethnicity

Region class has fields of name and doublelinkedlist ethnicities, which is used because per region there is multiple ethnicities to compare such as white,
black, asian, latinx, etc.

Input is where the main method is located and where we run the program; the program displays a GUI in which visualizes the data for the ethnicities per region
in a bar graph; you can change the region and sort either by CFR or Alpha
