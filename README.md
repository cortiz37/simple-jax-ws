## Jakarta 8 application (rs/ws)

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