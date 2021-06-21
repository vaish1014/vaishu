# BankBot

BankBot based on a Insurance Banking Bot to Human User question-answering system.

Domain: Frequently asked questions related to a Insurance Policy.

Requirements for running the code: 
1) Install Pandas:
	pip3.4 install --user pandas
2) Install Numpy:
	pip3.4 install --user numpy


Details:
* This chat-bot is based on a Insurance Banking Bot to Human User question-answering system.
* Questions were first stored in JSON file, which were originally retrieved from a Banking website.
* The JSON file were then transformed into a CSV file(where the section names were used as class names).
* The CSV file as well as the question asked by the user is processed using tf-idf vectorizing.

* When User asks a question, and the answer is not satisfactory – a list of suggestions of questions is given.

Example: 

if a question based on “loan” is asked, few suggestions are given based on “loan” word.

Ex Questions:

1) Why do I need health insurance?
2) What is a Benefit policy?
3) How is online investing more convenient?
