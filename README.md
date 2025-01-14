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