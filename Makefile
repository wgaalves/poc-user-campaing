start-stack: package
	docker-compose up --build --force-recreate -d
stop-stack:
	docker-compose down
package:
	gradle clean build -x test

