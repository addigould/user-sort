# User Sort
User-driven sorting for non-comparables.

Created by Addison Gould.

### About

As a young lad, I would see rating lists such as "100 Most Influential Rock Albums" or "Top 150 Films of the 20th Century". I felt that while the top few of the lists would be obviously deserving of their placement higher than the last few, but knew that in the middle there must be some arbitrariness in the placement, especially in larger lists. This irked me.

I realized that I could write a program that could prompt a user with a series of one-on-one comparisons so that the placement of every item in a ranked list would be justified. As the program is driven by user input, I neglected the program's computational time complexity (irrelevant here as it always waits for user response) and instead strove limit the number of comparisons the user has to make to a worst-case of nlog(n).

###How to use this program 

	1. Enter the data you wish to sort in a plain text file, one datum per line.
	2. Put that file in the "data" folder of the user-sort program directory
	3. Run UserSort.java
	4. Program will ask you for name of file to read from. Be sure to include the .txt extension.
	5. Follow program instructions.
	6. Program will ask you what you want the file containing the results to be called. Be sure to include .txt extension.
