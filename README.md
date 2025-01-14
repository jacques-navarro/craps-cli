```
       $$$$$$\                                                  $$$$$$\  $$\       $$$$$$\ 
      $$  __$$\                                                $$  __$$\ $$ |      \_$$  _|
      $$ /  \__| $$$$$$\  $$$$$$\   $$$$$$\   $$$$$$$\         $$ /  \__|$$ |        $$ |  
      $$ |      $$  __$$\ \____$$\ $$  __$$\ $$  _____|$$$$$$\ $$ |      $$ |        $$ |  
      $$ |      $$ |  \__|$$$$$$$ |$$ /  $$ |\$$$$$$\  \______|$$ |      $$ |        $$ |  
      $$ |  $$\ $$ |     $$  __$$ |$$ |  $$ | \____$$\         $$ |  $$\ $$ |        $$ |  
      \$$$$$$  |$$ |     \$$$$$$$ |$$$$$$$  |$$$$$$$  |        \$$$$$$  |$$$$$$$$\ $$$$$$\ 
       \______/ \__|      \_______|$$  ____/ \_______/          \______/ \________|\______|
                                   $$ |                                                    
                                   $$ |                                                    
                                   \__|
```

# Craps-CLI

A basic implementation of the [dice rolling game](https://en.wikipedia.org/wiki/Craps).

## Managing Game State

The state of the game is managed using an [Enum based State Machine](https://www.youtube.com/watch?v=-ZP2Xm-mY4E).

The [State Machine](https://github.com/jacques-navarro/craps-cli/blob/main/src/main/java/game/GameState.java) has six possible states:
1. START
2. GET_GOAL
3. SEEK_GOAL
4. WIN
5. LOSE
6. END

## Rules

### Roll out

Roll the dice:  
- Win if you roll a 7 or 11.
- Lose if you roll a 2, 3 or 12.
- Any other number rolled becomes the "point". You must roll this number again, before rolling a 7, in order to win.

### Object
- The object is to roll the "point" again. If you roll a 7 before rolling the "point" again, you lose.

## Play

### Main Menu

Press 1 at the main menu to start the game or 2 to see display the rules.

```
Craps

Select an Option
1 - Play
2 - See Rules
3 - Exit
Enter Choice:
```

### Start game

Press 1 once more at the next prompt to start the game or 2 to quit to the main menu.

```
1 - Roll Dice
2 - Quit
Enter Choice:
```

Rolling a 7 wins the game immediately.

```
You rolled 7.
You win!!
```

You lose the game right away if roll a 2, 3 or 12.

```
You rolled 3.
You Lose!!
```

If you roll any number other than a 7, 2, 3 or 11, it becomes the goal.

```
You rolled 10.
The goal is 10.

You rolled 3.
Press 1 to roll again
```

You must roll this number again, before rolling a 7 to win the game.

```
You rolled 10.
You win!!
```

## Deploy

These instructions will cover usage information and for the docker container

### Prerequisities

In order to run this container you'll need docker installed.

* [Windows](https://docs.docker.com/windows/started)
* [OS X](https://docs.docker.com/mac/started/)
* [Linux](https://docs.docker.com/linux/started/)

### Docker Image

1. Pull image from Docker Hub
```
docker pull jacquesnavarro/craps-cli
```

2. Verify image was pull successfully

```declarative
docker images
```

|        REPOSITORY        |   TAG  |   IMAGE ID   | CREATED           |  SIZE |
|:------------------------:|:------:|:------------:|-------------------|:-----:|
| jacquesnavarro/craps-cli | latest | 36b35702a29b | About an hour ago | 420MB |

3. Run container

```
docker run -it jacquesnavarro/craps-cli
```

### Docker Hub Repo

[jacquesnavarro/craps-cli](https://hub.docker.com/r/jacquesnavarro/craps-cli)

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/jacques-navarro/craps-cli/blob/main/LICENSE) file for details.
