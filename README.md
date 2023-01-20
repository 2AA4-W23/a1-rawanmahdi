# A1 - Piraten Karpen

  * Author: < You name here >
  * Email: < Your email here >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * <When the feature is ready to be tested by customer, provided it meets the conditions specified.>

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 | 14/01/23 |
| x   | F02 | Roll eight dices  |  D | 13/01/23  | 17/01/23 |
| x   | F03 | Play 42 games |  D  |  17/01/23 | 17/01/23 |
| x   | F04 | end of turn with three skulls | D | 17/01/23 | 17/01/23 |
| x   | F05 | Player keeping random dice at their turn | D | 17/01/23 | 19/01/23 | 
| x   | F06 | Score points: gold coins and diamonds | D | 19/01/2023 | 19/01/2023 | 
| x   | F07 | Display percetage of wins | D | 19/01/2023 | 20/01/2023 |
