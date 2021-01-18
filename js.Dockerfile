FROM node:alpine

WORKDIR /app
COPY . .

# Arguments
#ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=/app/react-frontend/node_modules/.bin

#COPY . /app

#RUN npm run build
RUN rm -rf node_modules

WORKDIR /app/react-frontend

COPY react-frontend/package*.json ./app/react-frontend/
#RUN ls -al

RUN rm package-lock.json
RUN rm -rf node_modules

RUN npm install -g react-scripts --silent
RUN npm install --silent

CMD ["npm", "start"] 

#RUN yarn install
#CMD ["yarn", "run", "start"]
