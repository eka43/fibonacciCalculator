## What is the overall goal of the project?
<h2>Fibonacci Calculator</h2><br>
<img alt="Fibonacci Calculator" src="sample.png?raw=true" width="80%"><br>
Once a user input the n value, it will show the result and time to calucate the result in microseconds.<br>

## Which languages did you use, and what parts of the system are implemented in each?
<img alt="Fibonacci Calculator structure" src="fibonacci.png?raw=true"><br>


- Javascript - React<br>
 I implemented frontend with React.<br>

- Java - Spring Boot <br>
 I implemented the REST API backend with Spring boot.<br>
 This server uses Spring Data JPA and maven.<br>
 Currently, it only has /GET and /POST.<br>
 The server will receive the result value from the Go server in string format.
 It will separate the value, convert and save it into JPA.

- Go - RPC with RabbitMQ<br>
 I used Go RPC server which calculates the fibonacci value and calculation time in microseconds.<br>
 It returns the value like 'responseValue/responseTime" in string format.<br>

## What methods did you use to communicate between languages?
1. RabbitMQ - This will be used to communicate between Spring server and Go RPC server.<br>
2. Used Axios with React so that the web app can communicate with Spring boot.<br>

## Deployment technology: Vagrant VM, or Docker containers.
Docker containers<br>

## How to run
- `git clone https://csil-git1.cs.surrey.sfu.ca/eka43/383-project.git`<br>
- `cd 383-project`<br>
- `docker-compose build && docker-compose up`<br>
- Once you see this (It might take around 20 seconds.)<br>
- `go_1        | 2020/12/11 03:21:06  [*] Awaiting RPC requests`,<br>
- open the web browser and type the `http://localhost:3000/`<br>
- Enjoy it<br>
- If docker doesn't work, try `docker-compose down` and run again please.

## What features should we be looking for when marking your project?
- Is deployment working well?<br>
- Is the frontend working well with the backend? <br> 
(Is a button or a table working properly? / Is the input value only accepting numbers?)<br> 
- Is the value shown properly?<br>
- Is spring boot connected with go server well?<br>
(You can check this through docker log messages.)<br>


###### This app is verified in Ubuntu 16.04 LTS and Ubuntu 20.04 LTS.