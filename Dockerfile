FROM eclipse-temurin:17

COPY src/main/java/ /src

WORKDIR /src

RUN ["javac",  "game/Main.java"]
RUN ["javac",  "game/Game.java"]
RUN ["javac",  "game/GameState.java"]
RUN ["javac",  "Dice/Dice.java"]
RUN ["javac",  "Dice/Die.java"]

ENTRYPOINT ["java", "game/Main"]