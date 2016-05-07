package yahtzee.ui;

public enum ScoreType {
	       
        ONES (0),
        TWOS (1),
        THREES (2),
        FOURS (3),
        FIVES (4),
        SIXES (5),
        CHANCE (6),
        TRIPLE (7),
        QUADRUPLE (8),
        SSTRAIGHT (9),
        LSTRAIGHT (10),
        FULLHOUSE (11),
        YAHTZEE (12);
 
       
        private final int index;
       
        ScoreType(int index)
        {
                this.index = index;
        }
       
        public int getIndex()
        {
                return this.index;
        }
}
