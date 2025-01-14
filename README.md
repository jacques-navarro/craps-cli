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

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/jacques-navarro/craps-cli/blob/main/LICENSE) file for details.
