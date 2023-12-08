package game;

public enum GameState {
    START {
        public GameState nextState(int input, int goal) {
            return GET_GOAL;
        }
    }, GET_GOAL {
        public GameState nextState(int input, int goal) {
            var nextState = switch (input) {
                case 7, 11 -> WIN;
                case 2, 3, 12 -> LOSE;
                case 4, 5, 6, 8, 9, 10 -> SEEK_GOAL;
                default -> throw new IllegalArgumentException("Something strange happened");
            };
            return nextState;
        }
    }, SEEK_GOAL {
        public GameState nextState(int input, int goal) {
            if (input == goal) {
                return GameState.WIN;
            } else if (input == 7) {
                return GameState.LOSE;
            } else {
                return SEEK_GOAL;
            }
        }
    }, WIN {
        public GameState nextState(int input, int goal) {
            return END;
        }
    }, LOSE {
        public GameState nextState(int input, int goal) {
            return END;
        }
    }, END {
        public GameState nextState(int input, int goal) {
            return START;
        }
    };

    public abstract GameState nextState(int input, int goal);

}
