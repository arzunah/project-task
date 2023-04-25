## som-mhp-puzzle


> ###### The Monty Hall test

The purpose of this test is to see how you design and write your code given a problem. Try to use right level of OOP. The problem is a well-known puzzle that you can read more about at http://en.wikipedia.org/wiki/Monty_Hall_problem . Save reading the link if you do not want to know the answer until you have solved the problem.

> ###### Problem Description

Assume that you are attending a TV show where you can win money by picking the right box. The game show host shows you three boxes explaining that the money is in one of the boxes. He asks you to pick one of them without opening it. After you have picked one of the boxes he opens one of the other two boxes which is empty. Now he turns to you and asks, do you want to change your mind, picking the remaining box?

> ###### Task

Write a readable and maintainable program in Java randomly simulating this event over and over again in the quest of answering following question. Do I stand a better chance to win if I change my mind? Maven should be used. The only assumption allowed is that three boxes exist.

Note: The program should run a real simulation. It is not allowed to figure out the outcome beforehand and implement according to that.

> ###### Conclusion

The application simulates 1000000 matches where the player does not change doors and 1000000 where he changes.
As expected, it is best to switch doors about 66.66% of the time.

---

> ###### Getting Started
Following instructions will give you a copy of the project up and running on your local machine for development, debugging and testing purposes.

###### Prerequisites
Requirements for tools to build and test

- `Quarkus ---> 2.16.6`
- `Maven ---> 3.9.1`


> ###### Installing
Below steps will guide you through to get your development environment up & running-

- Build using Maven Wrapper

```./mvnw clean install -U```

- Run using Maven Quarkus Dev

```./mvnw quarkus:dev```

> ###### Testing

```./mvnw clean test```

