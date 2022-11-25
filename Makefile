commit ?= default

server := virosa-server

build:
	@echo "build Spring Boot Project"
	@cd $(server) && ./gradlew build

push:
	@git add .
	@git commit -m "$(commit)"
	@git push
	@sync

clean:
	@cd $(server) && ./gradlew clean

