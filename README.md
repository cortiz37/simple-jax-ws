## simple-jax-ws (jakarta-8 app)

This is for training purposes: simple rest / soap with basic operations over `Element` entity

Branches:

- **master** (jakarta-ee (J2EE) + simple rest API / soap API)
- **develop** (simple web client example)

### Build

- unix: `./gradlew war`

- windows: `gradlew.bat war` 


#### Run (Docker):

- `docker build --tag=jboss .`
- `docker run -d -p 9090:8080 jboss`

#### Debug:

- `docker ps`
- copy `container_id`
- `docker logs <container_id>`
- `docker exec -it <container_id> bash`
