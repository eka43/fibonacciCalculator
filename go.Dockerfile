FROM golang:1.15

RUN go get github.com/streadway/amqp

WORKDIR /app

#RUN go get -d -v github.com/streadway/amqp github.com/google/uuid
#RUN go install -v github.com/streadway/amqp github.com/google/uuid

COPY . .

EXPOSE 5672
#EXPOSE 15672

RUN ls -al
CMD go run go-server/rpc_server.go

