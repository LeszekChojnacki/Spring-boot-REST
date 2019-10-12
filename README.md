# Spring-boot-REST
Spring boot REST with PostgreSQL  DB

The project basic assumptions:

Technology: Java 8, Spring (boot, REST, JPA / Hibernate), SQL server: PostgreSQL.
REST application calculating profits from the deposit
Capitalization of interest in the following periods: 1 month, 3 months, 6 months, 12 months
Two algorithms for calculating interest: - at the end of the deposit period / as at the calculation day
For simplicity, the month always has 30 days, the year 360.
Deposit parameters and calculation result stored in the database
Deposit data model: - name, interest rate, capitalization period, validity period (from - to)
Calculation data model: - amount, calculation date, deposit, interest calculation algorithm, profit
REST endpoints:

● GET api / investments - list of available deposits
  ○ entrance: none
  ○ output: header: 200, body: deposit list with data narrowed down to id and
  name

● POST api / investments - adds a new deposit
  ○ input: according to the model
  ○ output: header: 204, body: id, name, interest rate, duration in
  days

● POST api / investments / {id} / calculations - calculates the deposit
  ○ input: amount, interest algorithm
  ○ output: header: 204, body: amount, calculation date, deposit, algorithm, 
  
● GET api / investments / {id} / calculations - information on historical calculations
  ○ entrance: none
  ○ output: header: 200, body: deposit data and calculation list (amount, date
  calculation, algorithm, profit)

Unit tests for the code written: logic + endpoints
